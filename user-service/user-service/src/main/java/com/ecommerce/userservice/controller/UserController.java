package com.ecommerce.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.ecommerce.userservice.model.User;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    // ... method yang sudah ada ...
    
    // Method baru: User bisa lihat semua produk
    @GetMapping("/products")
    public String getUserProducts() {
        try {
            // Panggil Product Service via Gateway
            String products = restTemplate.getForObject(
                "http://localhost:8083/products", 
                String.class
            );
            return "Products available for users: " + products;
        } catch (Exception e) {
            return "Error connecting to Product Service: " + e.getMessage();
        }
    }
    
    // Method baru: User dashboard dengan info produk
    @GetMapping("/{id}/dashboard")
    public Map<String, Object> getUserDashboard(@PathVariable Long id) {
        Map<String, Object> dashboard = new HashMap<>();
        
        // Ambil data user
        User user = getUserById(id);
        dashboard.put("user", user);
        
        // Ambil info produk service
        try {
            String productInfo = restTemplate.getForObject(
                "http://localhost:8083/products/info", 
                String.class
            );
            dashboard.put("productServiceStatus", productInfo);
        } catch (Exception e) {
            dashboard.put("productServiceStatus", "Product Service unavailable");
        }
        
        return dashboard;
    }
}