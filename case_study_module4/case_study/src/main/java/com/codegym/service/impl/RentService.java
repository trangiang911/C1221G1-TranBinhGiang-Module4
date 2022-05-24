package com.codegym.service.impl;

import com.codegym.model.facility.RentType;
import com.codegym.repository.IRentRepository;
import com.codegym.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService implements IRentService<RentType> {
    @Autowired
    IRentRepository iRentRepository;

    @Override
    public List<RentType> findAll() {
        return this.iRentRepository.findAll();
    }
}
