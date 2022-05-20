package com.codegym.service;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPhoneService<Phone> {
    Page<com.codegym.model.Phone> findByName(String modelVal, Pageable pageable);

    Phone save(Phone phone);

    Optional<com.codegym.model.Phone> findById(Long id);

    void remove(Long id);
}
