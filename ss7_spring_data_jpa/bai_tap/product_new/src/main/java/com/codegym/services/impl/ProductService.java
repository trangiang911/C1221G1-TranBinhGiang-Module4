package com.codegym.services.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService<Product> {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Page<Product> findAndSearch(String nameVal, Pageable pageable) {
        return this.iProductRepository.findAndSearch("%"+nameVal+"%",pageable);
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.iProductRepository.deleteById(id);
    }
}
