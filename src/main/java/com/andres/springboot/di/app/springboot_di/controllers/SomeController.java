package com.andres.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.InterfaceProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired // lo quitamos para poner un condstructor se puede de las dos formas
    private InterfaceProduct serviceProduct;

    @GetMapping
    public List<Product> list() {
        return serviceProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product geProduct(@PathVariable Long id) {
        return serviceProduct.findById(id);
    }

}