package com.example.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product {

    @Id
    private String id;

    private String name;
    private double price;
    private String description;
    private String category;
    private String image;
}