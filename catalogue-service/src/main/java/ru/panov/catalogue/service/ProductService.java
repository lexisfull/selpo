package ru.panov.manager.service;

import ru.panov.manager.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Long productId);

    void updateProduct(Long id, String title, String details);

    void deleteProduct(Long id);
}
