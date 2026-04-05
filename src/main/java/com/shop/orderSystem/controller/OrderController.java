package com.shop.orderSystem.controller;
import com.shop.orderSystem.model.Order;
import com.shop.orderSystem.repository.OrderRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
   

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order){
         order.setStatus("Pending");
        Order saveOrder= orderRepository.save(order);
        return saveOrder;
    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/pending")
    public List<Order> getPendingOrders(){
        return orderRepository.findBystatus("Pending");
    }

// this is for upadete order status
   @PutMapping("/{id}/status")
    public  Order updateOrderStatus(@PathVariable Long id){
     Optional<Order> orderOptional= orderRepository.findById(id);
      if(orderOptional.isPresent()){
         Order order=orderOptional.get();
         order.setStatus("Delivered");
         return orderRepository.save(order);
      }else{
            throw new RuntimeException("Order not found with id: " + id);
      }
    }

    //delete data using id
    @DeleteMapping("/{id}")
    public String  deleteOrder(@PathVariable Long id){
     Optional<Order> existOrder= orderRepository.findById(id);
     if(existOrder.isPresent()){
         orderRepository.deleteById(id);
         return "Order deleted successfully";
     }else{
         return "Order not found with id: " + id;
     }
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
       Optional<Order> orderDetails= orderRepository.findById(id);
      if(orderDetails.isPresent()){
            return orderDetails.get();
      }else{
          return null;
      }
    }

   }
