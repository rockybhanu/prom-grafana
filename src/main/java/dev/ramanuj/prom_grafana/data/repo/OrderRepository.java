package dev.ramanuj.prom_grafana.data.repo;

import dev.ramanuj.prom_grafana.data.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<CustomerOrder, UUID> {

}
