package com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column(name = "product_quantity")
    private int quantity;

}