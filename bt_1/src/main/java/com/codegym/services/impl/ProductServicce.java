package com.codegym.services.impl;

import com.codegym.models.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicce implements IProductService<Product> {
    @Autowired
    IProductRepository iProductRepository;
}
