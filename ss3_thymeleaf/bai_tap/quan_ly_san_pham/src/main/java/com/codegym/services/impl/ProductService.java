package com.codegym.services.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.impl.ProductRepository;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService<Product> {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        this.iProductRepository.delete(id);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        this.iProductRepository.update(id,product);
    }

    @Override
    public List<Product> search(String name) {

        return this.iProductRepository.search(name);
    }
}
