package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService<Employee> {
    Page<Employee> findAndSearch(String nameVal, String addressBy, String positionBy, Pageable pageable);
}
