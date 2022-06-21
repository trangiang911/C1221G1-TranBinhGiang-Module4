package com.codegym.service;


import com.codegym.model.ProductType;

import java.util.List;

public interface IProductTypeService<ProductType> {

    List<com.codegym.model.ProductType> findAll();
}
