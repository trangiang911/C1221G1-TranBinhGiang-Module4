package com.codegym.services;

import java.util.List;

public interface ICategoryService<Category> {
    List<Category> findAll();
}
