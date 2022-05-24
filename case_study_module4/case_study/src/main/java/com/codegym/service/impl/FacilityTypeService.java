package com.codegym.service.impl;

import com.codegym.model.facility.FacilityType;
import com.codegym.repository.IFacilityRepository;
import com.codegym.repository.IFacilityTypeRepository;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService<FacilityType> {
    @Autowired
    IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
      return this.iFacilityTypeRepository.findAll();
    }
}
