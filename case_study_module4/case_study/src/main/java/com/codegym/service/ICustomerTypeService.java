package com.codegym.service;

import java.util.List;

public interface ICustomerTypeService<CustomerType> {
    List<CustomerType> findAll();
}
