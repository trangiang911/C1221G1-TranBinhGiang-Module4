package com.codegym.service.impl;

import com.codegym.model.ProductType;
import com.codegym.repository.IProductTypeRepository;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService<ProductType> {
    @Autowired
    IProductTypeRepository iProductTypeRepository;


    @Override
    public List<ProductType> findAll() {
        return this.iProductTypeRepository.findAll();
    }
}
