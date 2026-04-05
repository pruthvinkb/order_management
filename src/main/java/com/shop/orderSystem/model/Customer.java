package com.shop.orderSystem.model;
 
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String name;
    private String phone;
    private String address;
}
