package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public List findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Object findById(Integer id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public List search(String name) {
        return this.iBlogRepository.findAllBlog("%"+name+"%");
    }
}
