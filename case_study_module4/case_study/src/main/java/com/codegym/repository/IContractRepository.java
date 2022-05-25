package com.codegym.repository;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value="select * from contract where employee_id like :employeeVal and customer_id like :customerVal and facility_id like :serviceVal",
    countQuery="select * from contract where employee_id like :employeeVal and customer_id like :customerVal and facility_id like :serviceVal",nativeQuery=true)
    Page<Contract> findAndSearch(String employeeVal, String customerVal, String serviceVal, Pageable pageable);
}
