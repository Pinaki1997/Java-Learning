package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(String productId) throws ProductNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(String name, String category, String description, String price, String image) {
        return null;
    }

    @Override
    public Product updateProduct(String productId, String name, String category, String description, String price, String image) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public String deleteProduct(String productId) {
        return "";
    }

    private Product convertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.id);
        product.setName(fakeStoreProductDto.title);
        product.setPrice(fakeStoreProductDto.price);
        product.setDescription(fakeStoreProductDto.description);
        product.setCategory(fakeStoreProductDto.category);
        product.setImage(fakeStoreProductDto.image);
        return product;
    }
}
