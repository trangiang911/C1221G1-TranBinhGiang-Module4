package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService<Product> {
    Page<Product> findAndSearch(String nameVal, Pageable pageable);

    Optional<com.codegym.model.Product> findById(Integer id);
}
