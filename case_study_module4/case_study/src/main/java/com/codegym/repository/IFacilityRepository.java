package com.codegym.repository;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value="select * from facility where facility_name like :nameVal and facility_type_id like :typeBy and rent_type_id like :rentBy",
    countQuery="select * from facility where facility_name like :nameVal and facility_type_id like :typeBy and rent_type_id like :rentBy",nativeQuery=true)
    Page<Facility> findAndSearch(String nameVal, String rentBy, String typeBy, Pageable pageable);
}
