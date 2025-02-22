package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {

        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // Product newProduct = new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());

    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}