package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService<Category> {
    List<Category> findAll();

    Page<com.codegym.model.Category> findAllPage(Pageable pageable);
}
