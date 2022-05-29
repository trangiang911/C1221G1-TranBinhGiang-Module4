package com.codegym.service.impl;

import com.codegym.dto.CustomerHaveBooking;
import com.codegym.model.customer.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAndSearch(String nameVal,String addressBy,String typeBy, Pageable pageable) {
        return this.iCustomerRepository.findAndSearch("%"+nameVal+"%","%"+addressBy+"%",typeBy,pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable) {
        return this.iCustomerRepository.findAllCustomerHaveBooking(pageable);
    }
}
