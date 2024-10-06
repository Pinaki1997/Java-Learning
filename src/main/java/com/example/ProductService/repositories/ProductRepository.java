package com.example.ProductService.repositories;

import com.example.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstByNameAndCategory(String name, String category);

    List<Product> findAll();

    Product findById(String id);

    Product findFirstByNameAndCategoryAndIdNot(String name, String category, String id);
}
