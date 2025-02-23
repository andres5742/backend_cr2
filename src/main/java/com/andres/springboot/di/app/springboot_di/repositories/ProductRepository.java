package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.andres.springboot.di.app.springboot_di.models.Product;

@Component
public class ProductRepository implements InterfaceProducto {

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "memoria corsair 32", 300L),
                new Product(2L, "cpu intel core i9", 1500L),
                new Product(3L, "pantalla asus full hd", 500L),
                new Product(4L, "teclado mecanico 70%", 250L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}