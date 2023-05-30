package com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Service;

import com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Model.Product;
import com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
    @Override
    public Product getProductById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        } else {
            throw new RuntimeException("Product not found for id: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(int id) {
        this.productRepository.deleteById(id);
    }
}
