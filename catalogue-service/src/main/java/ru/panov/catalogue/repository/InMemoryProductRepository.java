package ru.panov.manager.repository;

import org.springframework.stereotype.Repository;
import ru.panov.manager.entity.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream()
                .max(Comparator.comparingLong(Product::getId))
                .map(Product::getId)
                .orElse(0L) + 1L);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return this.products.stream()
                .filter(product -> Objects.equals(productId, product.getId()))
                .findFirst();
    }

    @Override
    public void delteById(Long id) {
        this.products.removeIf(product -> Objects.equals(id, product.getId()));
    }
}
