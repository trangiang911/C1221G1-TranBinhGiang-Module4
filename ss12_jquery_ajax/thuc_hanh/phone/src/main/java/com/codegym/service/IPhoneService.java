package com.codegym.service;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhoneService<Phone> {
    Page<com.codegym.model.Phone> findByName(String modelVal, Pageable pageable);

    Phone save(Phone phone);
}
