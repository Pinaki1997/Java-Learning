package com.example.ProductService.services;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(String productId) throws ProductNotFoundException;

    public Product createProduct(String name, String category, String description, String price, String image);

    public Product updateProduct(String productId, String name, String category, String description, String price, String image) throws ProductNotFoundException;

    public List<Product> getProducts();

    public String deleteProduct(String productId) throws ProductNotFoundException;
}