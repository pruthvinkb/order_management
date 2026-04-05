package com.shop.orderSystem.model;
 //this To connect Java class → Database table give entity and id other
import jakarta.persistence.*;
// To reduce codeto geter and setter
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String username;

     private String password;
}
