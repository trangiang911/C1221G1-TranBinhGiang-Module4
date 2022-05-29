package com.codegym.services.impl;

import com.codegym.models.ProductType;
import com.codegym.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService<ProductType> {
    @Autowired
    IProductTypeService iProductTypeService;
}
