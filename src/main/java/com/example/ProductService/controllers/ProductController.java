package com.example.ProductService.controllers;

import com.example.ProductService.dtos.CreateProductRequestDto;
import com.example.ProductService.dtos.UpdateProductRequestDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Qualifier("dbImpl")
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String productId) throws ProductNotFoundException {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        return productService.createProduct(requestDto.getName(), requestDto.getCategory(),
                requestDto.getDescription(), requestDto.getPrice(), requestDto.getImage());
    }

    @PutMapping()
    public Product updateProduct(@RequestBody UpdateProductRequestDto requestDto) throws ProductNotFoundException {
        return productService.updateProduct(requestDto.getId(), requestDto.getName(), requestDto.getCategory(),
                requestDto.getDescription(), requestDto.getPrice(), requestDto.getImage());
    }

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(value = "id") String productId) throws ProductNotFoundException {
        return productService.deleteProduct(productId);
    }
}
