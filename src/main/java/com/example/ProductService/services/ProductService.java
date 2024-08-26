package com.example.ProductService.services;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;

public interface ProductService {
    public Product getProductById(int productId) throws ProductNotFoundException;
}
