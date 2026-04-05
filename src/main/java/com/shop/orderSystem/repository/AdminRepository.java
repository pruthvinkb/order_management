package com.shop.orderSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.orderSystem.model.Admin;

public interface  AdminRepository extends JpaRepository<Admin,Integer>   {
   Admin findByUsername(String username); 
}
