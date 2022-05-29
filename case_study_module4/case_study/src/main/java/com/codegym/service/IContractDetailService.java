package com.codegym.service;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService<ContractDetail> {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(com.codegym.model.contract.ContractDetail contractDetail);
}
