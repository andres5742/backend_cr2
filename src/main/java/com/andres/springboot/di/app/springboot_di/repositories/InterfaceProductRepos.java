package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.andres.springboot.di.app.springboot_di.models.Product;

public interface InterfaceProductRepos {

    List<Product> findAll();


    Product findById(Long id);

    
}