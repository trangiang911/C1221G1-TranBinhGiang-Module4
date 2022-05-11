package com.codegym.service.impl;

import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryService iCategoryService;
    @Override
    public List findAll() {
        return this.iCategoryService.findAll();
    }
}
