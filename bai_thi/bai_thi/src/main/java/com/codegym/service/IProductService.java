package com.codegym.service;

import java.util.List;

public interface IProductService<Product> {
    List<Product> findAll();

    List<Product> findAllById(Integer id);
}
