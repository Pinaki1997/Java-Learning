package com.example.ProductService.dtos;

import lombok.Data;

@Data
public class UpdateProductRequestDto {
    String id;
    String name;
    String category;
    String description;
    String price;
    String image;
}
