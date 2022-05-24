package com.codegym.service.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService<Facility> {
    @Autowired
    IFacilityRepository iFacilityRepository;


    @Override
    public Page<Facility> findAndSearch(String nameVal, String rentBy, String typeBy, Pageable pageable) {
        return this.iFacilityRepository.findAndSearch("%"+nameVal+"%",rentBy,typeBy,pageable);
    }

    @Override
    public void save(Facility facility) {
        if(facility.getPoolArea().equals("")){
            facility.setPoolArea(null);
        }if(facility.getNumberOfFloors().equals("")){
            facility.setNumberOfFloors(null);
        }
        this.iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return this.iFacilityRepository.findById(id).orElse(null);
    }
}
