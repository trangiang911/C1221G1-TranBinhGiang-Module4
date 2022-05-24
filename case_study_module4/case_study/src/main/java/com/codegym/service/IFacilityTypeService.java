package com.codegym.service;

import java.util.List;

public interface IFacilityTypeService<FacilityType> {
    List<FacilityType> findAll();
}
