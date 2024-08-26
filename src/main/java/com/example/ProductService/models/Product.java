package com.example.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    int id;
    String name;
    double price;
    String description;
    String category;
    String image;
}