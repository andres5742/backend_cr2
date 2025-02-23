package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.springboot_di.models.Product;


@Repository("productoFoo")
public class ProductRepositoryFoo implements InterfaceProduct {

    @Override
    public List<Product> findAll() {

        return Collections.singletonList(new Product(1L, "mouse genuis ergonomico", 40L));
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return new Product(id, "mouse genuis ergonomico", 40L);
    }

}