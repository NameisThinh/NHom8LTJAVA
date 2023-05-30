package com.example.buoi5.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buoi5.Model.Product;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();

    public void add(Product newProduct){
        listProduct.add(newProduct);
    }
    public List<Product> GetAll(){
        return listProduct;
    }
}
