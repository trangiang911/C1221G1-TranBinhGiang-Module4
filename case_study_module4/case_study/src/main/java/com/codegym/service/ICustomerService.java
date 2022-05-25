package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService<Customer> {
    Page<Customer> findAndSearch(String nameVal,String addressBy,String typeBy, Pageable pageable);

    void save(com.codegym.model.customer.Customer customer);

    void remove(Integer id);

    Customer findById(Integer id);

    List<Customer> findAll();
}
