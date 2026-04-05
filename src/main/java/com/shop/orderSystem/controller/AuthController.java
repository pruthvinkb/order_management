package com.shop.orderSystem.controller;

import com.shop.orderSystem.model.Admin;
import com.shop.orderSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    private boolean isLoggedIn = false;

    // 🔹 Register
    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        if (admin == null) {
          throw new RuntimeException("Admin cannot be null");
           }
        return adminRepository.save(admin);
    }

    // 🔹 Find admin
    @GetMapping("/find/{username}")
    public Admin findByUsername(@PathVariable String username) {
        return adminRepository.findByUsername(username);
    }

    // 🔹 Login
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {

        Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());

        if (existingAdmin != null &&
            existingAdmin.getPassword().equals(admin.getPassword())) {

            isLoggedIn = true;
            return "Login successful";

        } else {
            return "Invalid username or password";
        }
    }

    // 🔹 Logout (NEW 🔥)
    @PostMapping("/logout")
    public String logout() {
        isLoggedIn = false;
        return "Logged out successfully";
    }

    // 🔹 Check login
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}