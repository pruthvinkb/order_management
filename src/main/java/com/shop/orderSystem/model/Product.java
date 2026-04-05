package com.shop.orderSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;


@Entity
@Table(name= "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

   @NotBlank(message="product  name is required")
    private String name; 

    @NotBlank(message = "product URL is required")
    private String imageUrl;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private double price;

     // 🔥 DEFAULT CONSTRUCTOR (VERY IMPORTANT)
    public Product() {}

    // 🔥 GETTERS & SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



