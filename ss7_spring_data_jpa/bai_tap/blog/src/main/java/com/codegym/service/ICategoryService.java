package com.codegym.service;

import java.util.List;

public interface ICategoryService<Category> {
    List<Category> findAll();
}
