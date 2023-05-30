package com.example.NguyenQuocThinhBuoi6LT.Service;

import com.example.NguyenQuocThinhBuoi6LT.Model.Product;
import com.example.NguyenQuocThinhBuoi6LT.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;


    public List<Product> Getall(){
        return (List<Product>) repo.findAll();
    }
    public void add(Product newProduct){ repo.save(newProduct);}
    public void edit( Product editProduct) {

      repo.save(editProduct);
    }
    public Product getProductById(Integer id){

        return repo.findById(id).orElse(null);
    }
    public void delete(Product deleteProduct){
        repo.delete(deleteProduct);
    }
}
