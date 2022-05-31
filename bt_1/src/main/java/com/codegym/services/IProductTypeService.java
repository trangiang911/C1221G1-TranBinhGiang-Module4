package com.codegym.services;


import com.codegym.models.ProductType;

import java.util.List;

public interface IProductTypeService<ProductType> {

    List<com.codegym.models.ProductType> findAll();
}
