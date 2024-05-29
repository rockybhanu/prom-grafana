package dev.ramanuj.prom_grafana.service;

import dev.ramanuj.prom_grafana.data.entity.Product;
import dev.ramanuj.prom_grafana.data.repo.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
