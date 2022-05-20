package com.codegym.service.impl;

import com.codegym.model.Phone;
import com.codegym.repositpry.IPhoneRepository;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Phone> findById(Long id) {
        return this.iPhoneRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        this.iPhoneRepository.deleteById(id);
    }
}
