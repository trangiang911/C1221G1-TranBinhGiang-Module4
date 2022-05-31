package com.codegym.services.impl;

import com.codegym.models.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicce implements IProductService<Product> {
    @Autowired
    IProductRepository iProductRepository;


    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public List<Product> findAllById(Integer id) {
        return this.iProductRepository.findAllByProductType_ProductTypeId(id);
    }
}
