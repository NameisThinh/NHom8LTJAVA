package com.example.buoi5.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class Product {
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống.")
    private String name;

    @Length(min = 0, max =500 , message = "Tên ảnh không được quá 50 ky tu")
    private String image;

    @NotNull(message="Gía sản phẩm không được để trống")
    @Min(value=1, message=" Gía không nhỏ hơn 1")
    @Max(value=999999, message=" Gía không quá 99999")
    private long price;
    

}
