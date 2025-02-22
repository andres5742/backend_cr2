package com.andres.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService serviceProduct = new ProductService();

    @GetMapping
    public List<Product> list() {
        return serviceProduct.findAll();
    }


    @GetMapping("/{id}")
    public Product geProduct(@PathVariable Long id) {
        return serviceProduct.findById(id);
    }
    
}