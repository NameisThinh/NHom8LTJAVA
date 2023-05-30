package com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Repository;

import com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
