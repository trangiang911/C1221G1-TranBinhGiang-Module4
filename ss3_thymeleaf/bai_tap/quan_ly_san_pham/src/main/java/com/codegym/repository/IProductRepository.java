package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void delete(Integer id);

    Product findById(Integer id);

    void update(Integer id, Product product);

    List<Product> search(String name);
}
