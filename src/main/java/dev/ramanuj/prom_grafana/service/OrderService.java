package dev.ramanuj.prom_grafana.service;

import dev.ramanuj.prom_grafana.data.entity.CustomerOrder;
import dev.ramanuj.prom_grafana.data.repo.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public CustomerOrder saveOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public Optional<CustomerOrder> getOrderById(UUID id) {
        return orderRepository.findById(id);
    }

    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
}
