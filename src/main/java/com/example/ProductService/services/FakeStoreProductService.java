package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return convertToProduct(fakeStoreProductDto);
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
