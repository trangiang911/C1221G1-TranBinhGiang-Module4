package com.codegym.service.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService<Contract> {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAndSearch(String employeeVal, String customerVal, String serviceVal, Pageable pageable) {
        return this.iContractRepository.findAndSearch(employeeVal,customerVal,serviceVal,pageable);
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public void delete(List<Integer> integerList) {
        this.iContractRepository.deleteAllById(integerList);
    }

    @Override
    public List<Contract> findAll() {
        return this.iContractRepository.findAll();
    }
}
