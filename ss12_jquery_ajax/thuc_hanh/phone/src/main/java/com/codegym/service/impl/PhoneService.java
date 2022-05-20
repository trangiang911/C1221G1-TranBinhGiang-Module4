package com.codegym.service.impl;

import com.codegym.model.Phone;
import com.codegym.repositpry.IPhoneRepository;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService<Phone> {
    @Autowired
    IPhoneRepository iPhoneRepository;

    @Override
    public Page<Phone> findByName(String modelVal, Pageable pageable) {
        return this.iPhoneRepository.findByName("%"+modelVal+"%",pageable);
    }

    @Override
    public Phone save(Phone phone) {
        return this.iPhoneRepository.save(phone);
    }
}
