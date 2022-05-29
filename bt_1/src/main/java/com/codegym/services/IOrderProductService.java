package com.codegym.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

public interface IOrderProductService<OrderProduct>{
    Page<OrderProduct> findAndSearch(String dateStartBy, String dateEndBy, Pageable pageable);
}
