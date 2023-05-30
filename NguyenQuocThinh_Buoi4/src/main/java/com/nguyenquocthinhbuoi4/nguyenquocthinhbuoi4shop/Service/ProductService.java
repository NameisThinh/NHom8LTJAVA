package com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Service;

import com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
}
