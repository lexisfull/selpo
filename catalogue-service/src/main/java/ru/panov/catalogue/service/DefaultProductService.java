package ru.panov.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.panov.manager.entity.Product;
import ru.panov.manager.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(Long productId) {
        return this.productRepository.findById(productId);
    }

    @Override
    public void updateProduct(Long id, String title, String details) {
        this.productRepository.findById(id)
                .ifPresentOrElse(product -> {product.setTitle(title);
                            product.setDetails(details);
                            }, ()-> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.delteById(id);
    }
}
