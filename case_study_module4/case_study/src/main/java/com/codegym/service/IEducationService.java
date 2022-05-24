package com.codegym.service;

import com.codegym.model.employee.EducationDegree;

import java.util.List;

public interface IEducationService<EducationDegree> {
    List<com.codegym.model.employee.EducationDegree> findAll();
}
