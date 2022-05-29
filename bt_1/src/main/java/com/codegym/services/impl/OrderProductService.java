package com.codegym.services.impl;

import com.codegym.models.OrderProduct;
import com.codegym.repository.IOrderProductRepository;
import com.codegym.services.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderProductService implements IOrderProductService<OrderProduct> {
    @Autowired
    IOrderProductRepository iOrderProductRepository;

    @Override
    public Page<OrderProduct> findAndSearch(String dateStartBy, String dateEndBy, Pageable pageable) {
        return this.iOrderProductRepository.findAndSearch(dateStartBy,dateEndBy,pageable);
    }

}
