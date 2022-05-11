package com.codegym.services;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService<Product> {
    Page<Product> findAndSearch(String nameVal, Pageable pageable);

    void save(com.codegym.model.Product product);

    Product findById(Integer id);

    void delete(Integer id);
}
