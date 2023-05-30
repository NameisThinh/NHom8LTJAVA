package com.nhom17buoi5.nhom17buoi5.controller;

import com.nhom17buoi5.nhom17buoi5.models.Product;
import com.nhom17buoi5.nhom17buoi5.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("listproduct", productService.getListProduct());
        return "/products/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/products/create";
    }

//    @PostMapping("/create")
//    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
//        if(result.hasErrors()){
//            model.addAttribute("product", newProduct);
//            return "products/create";
//        }
//        if(imageProduct != null && imageProduct.getSize() > 0){
//            try{
//                File saveFile = new ClassPathResource("static/images").getFile();
//                String newImageFile = UUID.randomUUID() + ".png";
//                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
//                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//                newProduct.setImage(newImageFile);
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//        }
//        productService.add(newProduct);
//        return "redirect:/products";
//    }

    @PostMapping("/create")
    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", newProduct);
            return "products/create";
        }
        if(imageProduct != null && imageProduct.getSize() > 0){
            try{
//                 byte[] bytes = imageProduct.getBytes();
//                 Path path = Paths.get( "F:/Java_Dev/nhom17-buoi5/src/main/resources/static/images" + "/" + imageProduct.getOriginalFilename());
//                 Files.write(path, bytes);
//                 newProduct.setImage(imageProduct.getOriginalFilename());
                byte[] bytes = imageProduct.getBytes();
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.write(path, bytes);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        productService.add(newProduct);
        return "redirect:/products";
    }


    @GetMapping("/search?key=")
    public List<Product> search(@RequestParam String key){
        return productService.search(key);
    }
    @PostMapping("/edit")
    public String edit (@Valid Product editProduct, @RequestParam MultipartFile imageProduct , BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("product" ,editProduct);
            return "products/edit";
        }
        if(imageProduct !=null &&imageProduct.getSize()>0){
            try {
                File saveFile=  new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + editProduct.getImage());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        productService.edit(editProduct);
        return "redirect:/products";
    }

}
