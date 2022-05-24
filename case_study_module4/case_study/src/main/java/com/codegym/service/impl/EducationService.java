package com.codegym.service.impl;

import com.codegym.model.employee.EducationDegree;
import com.codegym.repository.IEducationRepository;
import com.codegym.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService<EducationDegree> {
    @Autowired
    IEducationRepository iEducationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.iEducationRepository.findAll();
    }
}
