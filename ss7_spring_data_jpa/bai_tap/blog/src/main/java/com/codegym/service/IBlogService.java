package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService<Blog> {
    List<Blog> findAll();

    com.codegym.model.Blog findById(Integer id);

    void save(com.codegym.model.Blog blog);

    void deleteById(Integer id);


    Page<Blog> findByname(String nameVal, Pageable pageable);

    Page<com.codegym.model.Blog> findByCate(Optional<String> category, Pageable pageable);
}
