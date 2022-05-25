package com.codegym.service;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService<Facility> {
    Page<Facility> findAndSearch(String nameVal, String rentBy, String typeBy, Pageable pageable);

    void save(com.codegym.model.facility.Facility facility);

    com.codegym.model.facility.Facility findById(Integer id);

    List<Facility> findAll();
}
