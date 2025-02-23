package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.InterfaceProduct;

@Service
public class ProductService implements InterfaceServiceProducto {

    //  @Autowired // lo quitamos para poner un condstructor se puede de las dos   formas
    private InterfaceProduct repository;

    // en este caso no funciono el Qualifier no to el repositorio que puse solo tomo
    // el primary    
    public ProductService(@Qualifier("productoFoo") InterfaceProduct repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // Product newProduct = new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());

    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}