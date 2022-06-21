package com.codegym.service;

import com.codegym.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderProductService<OrderProduct> {
    Page<OrderProduct> findAndSearch(String dateStartBy, String dateEndBy, Pageable pageable);


    Page<OrderProduct> findTop(Pageable pageable);

    OrderProduct findById(Integer id);

    void save(com.codegym.model.OrderProduct orderProduct);
}
