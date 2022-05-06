package com.codegym.services;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService<Product> {
    List<Product> findAll();

    void save(com.codegym.model.Product product);

    void delete(Integer id);

    Product findById(Integer id);

    void update(Integer id, com.codegym.model.Product product);

    List<Product> search(String name);
}
