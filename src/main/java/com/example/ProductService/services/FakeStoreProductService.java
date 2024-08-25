package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
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
