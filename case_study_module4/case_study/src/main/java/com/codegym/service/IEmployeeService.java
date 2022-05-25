package com.codegym.service;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService<Employee> {
    Page<Employee> findAndSearch(String nameVal, String addressBy, String positionBy, Pageable pageable);

    void save(com.codegym.model.employee.Employee employee);

    com.codegym.model.employee.Employee findById(Integer id);

    void deleteById(Integer id);

    List<Employee> findAll();
}
