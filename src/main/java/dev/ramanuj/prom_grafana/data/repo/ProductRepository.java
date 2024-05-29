package dev.ramanuj.prom_grafana.data.repo;

import dev.ramanuj.prom_grafana.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
