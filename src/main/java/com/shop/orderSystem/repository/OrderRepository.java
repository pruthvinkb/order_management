package com.shop.orderSystem.repository;
import com.shop.orderSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findBystatus(String status);
}
