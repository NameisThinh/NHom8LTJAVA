package com.example.NguyenQuocThinhBuoi6LT.Repository;

import com.example.NguyenQuocThinhBuoi6LT.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
