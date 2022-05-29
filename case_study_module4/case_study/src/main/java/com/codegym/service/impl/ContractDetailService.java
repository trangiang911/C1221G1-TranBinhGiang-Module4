package com.codegym.service.impl;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import com.codegym.repository.IContractDetailRepository;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService<ContractDetail> {
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return this.iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.iContractDetailRepository.save(contractDetail);
        Contract contract=this.iContractRepository.findById(contractDetail.getContract().getContractId()).orElse(null);
        Double total=Double.parseDouble(contract.getFacility().getFacilityCost())+(Double.parseDouble(contractDetail.getQuantity())*(Double.parseDouble(contractDetail.getAttachService().getAttachServiceCost())));
        contract.setContractTotalMoney(total.toString());
        this.iContractRepository.save(contract);
    }
}
