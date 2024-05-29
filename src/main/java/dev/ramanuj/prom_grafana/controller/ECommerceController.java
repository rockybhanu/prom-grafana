package dev.ramanuj.prom_grafana.controller;

import dev.ramanuj.prom_grafana.data.entity.CustomerOrder;
import dev.ramanuj.prom_grafana.data.entity.Product;
import dev.ramanuj.prom_grafana.service.OrderService;
import dev.ramanuj.prom_grafana.service.ProductService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ECommerceController {

    private final ProductService productService;

    private final OrderService orderService;

    @PostMapping("/products")
    @Timed(value = "product.create.time", description = "Time taken to create a product")
    @Counted(value = "product.create.count", description = "Times product creation is invoked")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    @Timed(value = "product.get.time", description = "Time taken to get a product")
    @Counted(value = "product.get.count", description = "Times product retrieval is invoked")
    public Optional<Product> getProduct(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    @Timed(value = "products.getAll.time", description = "Time taken to get all products")
    @Counted(value = "products.getAll.count", description = "Times all products retrieval is invoked")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/products/{id}")
    @Timed(value = "product.delete.time", description = "Time taken to delete a product")
    @Counted(value = "product.delete.count", description = "Times product deletion is invoked")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/orders")
    @Timed(value = "order.create.time", description = "Time taken to create an order")
    @Counted(value = "order.create.count", description = "Times order creation is invoked")
    public CustomerOrder createOrder(@RequestBody CustomerOrder customerOrder) {
        return orderService.saveOrder(customerOrder);
    }

    @GetMapping("/orders/{id}")
    @Timed(value = "order.get.time", description = "Time taken to get an order")
    @Counted(value = "order.get.count", description = "Times order retrieval is invoked")
    public Optional<CustomerOrder> getOrder(@PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/orders")
    @Timed(value = "orders.getAll.time", description = "Time taken to get all orders")
    @Counted(value = "orders.getAll.count", description = "Times all orders retrieval is invoked")
    public List<CustomerOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/orders/{id}")
    @Timed(value = "order.delete.time", description = "Time taken to delete an order")
    @Counted(value = "order.delete.count", description = "Times order deletion is invoked")
    public void deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
    }
}
