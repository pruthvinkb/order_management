package com.shop.orderSystem.repository;

import com.shop.orderSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   
//import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

} 
