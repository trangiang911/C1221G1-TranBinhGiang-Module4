package com.codegym.service.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService<Employee> {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAndSearch(String nameVal, String addressBy, String positionBy, Pageable pageable) {
        return this.iEmployeeRepository.findAndSearch("%"+nameVal+"%","%"+addressBy+"%",positionBy,pageable);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.iEmployeeRepository.deleteById(id);
    }


}
