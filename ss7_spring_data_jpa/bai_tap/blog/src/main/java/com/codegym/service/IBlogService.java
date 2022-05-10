package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService<Blog> {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(com.codegym.model.Blog blog);

    void deleteById(Integer id);

    List<Blog> search(String name);
}
