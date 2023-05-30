package com.example.NguyenQuocThinhBuoi6LT.Model;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column
    private String name;
@Column
    private String image;
@Column
    private long price;
}
