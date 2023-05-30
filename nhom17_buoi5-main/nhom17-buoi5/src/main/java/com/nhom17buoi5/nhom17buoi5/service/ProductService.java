package com.nhom17buoi5.nhom17buoi5.service;

import com.nhom17buoi5.nhom17buoi5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();

    public ProductService() {

    }

    public void add(Product newProduct) {
        listProduct.add(newProduct);
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public Product getProductById(int id) {
        return listProduct.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void edit(Product editProduct) {
        Product find = listProduct.get(editProduct.getId());
        if (find != null) {
            find.setName(editProduct.getName());
            find.setImage(editProduct.getImage());
            find.setPrice(editProduct.getPrice());
        }
    }

    public List<Product> search(String key){
        return listProduct.stream().filter(p -> p.getName().toLowerCase().contains(key)).toList();
    }
}
