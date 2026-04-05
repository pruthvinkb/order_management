package com.shop.orderSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
@Entity
@Data
@NoArgsConstructor
@Table(name= "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private long id;
   @NotBlank(message="Customer name is required")
    String customerName;
    @NotNull(message="Customer phone is required")
    Long customerPhone;
    @NotBlank(message="Customer  address  not be Empty")
    String customerAddress;
    @NotBlank(message="Order items  not be Empty")
    String items;
    private String status;
}
