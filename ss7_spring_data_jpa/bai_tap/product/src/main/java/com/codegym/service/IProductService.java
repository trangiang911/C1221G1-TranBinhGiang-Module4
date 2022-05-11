package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService<Product> {


    Page<Product> findAndSearch(String nameVal, Pageable pageable);
}
