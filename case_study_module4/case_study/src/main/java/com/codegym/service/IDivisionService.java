package com.codegym.service;

import com.codegym.model.employee.Division;

import java.util.List;

public interface IDivisionService<Division> {
    List<com.codegym.model.employee.Division> findAll();
}
