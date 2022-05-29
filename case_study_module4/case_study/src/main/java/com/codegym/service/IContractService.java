package com.codegym.service;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService<Contract> {
    Page<Contract> findAndSearch(String employeeVal, String customerVal, String serviceVal, Pageable pageable);

    void save(com.codegym.model.contract.Contract contract);

    void delete(List<Integer> integerList);

    List<Contract> findAll();
}
