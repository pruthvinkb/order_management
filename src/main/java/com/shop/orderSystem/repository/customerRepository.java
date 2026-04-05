package com.shop.orderSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.orderSystem.model.Customer;

public interface customerRepository extends JpaRepository<Customer,Integer>{
  
   
} 
    