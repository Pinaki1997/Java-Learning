package com.example.ProductService.services;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("dbImpl")
public class ProductServiceDbImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(String productId) throws ProductNotFoundException {
        Product p = productRepository.findById(productId);
        if(p == null){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return p;
    }

    @Override
    public Product createProduct(String name, String category, String description, String price, String image) {
        Product p = productRepository.findFirstByNameAndCategory(name, category);
        if(p != null){
            return p;
        }
        UUID uuid = UUID.randomUUID();
        Product product = new Product();
        product.setId(uuid.toString());
        product.setPrice(Double.parseDouble(price));
        product.setImage(image);
        product.setCategory(category);
        product.setDescription(description);
        product.setName(name);
        product = productRepository.save(product);
        System.out.println(product.getId());
        return product;
    }

    @Override
    public Product updateProduct(String productId, String name, String category, String description, String price, String image) throws ProductNotFoundException {
        Product p = productRepository.findById(productId);
        if(p == null){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        Product existingProduct = productRepository.findFirstByNameAndCategoryAndIdNot(name, category, productId);
        if(existingProduct != null){
            return existingProduct;
        }

        p.setName(name);
        p.setCategory(category);
        p.setDescription(description);
        p.setPrice(Double.parseDouble(price));
        p.setImage(image);
        p = productRepository.save(p);
        return p;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(String productId) throws ProductNotFoundException {
        Product p = productRepository.findById(productId);
        if(p == null){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        productRepository.delete(p);
        return "Product with id " + productId + " deleted";
    }
}
