package ru.panov.manager.repository;

import ru.panov.manager.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long productId);

    void delteById(Long id);
}
