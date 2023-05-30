package com.nguyenquocthinhbuoi4.nguyenquocthinhbuoi4shop.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private int productId;
    private String name;
    private double price;
    private double quantity = 1;




}
