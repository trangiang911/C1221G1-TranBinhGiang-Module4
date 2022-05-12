package com.codegym.service.impl;

import com.codegym.model.Form;
import com.codegym.repository.IFormRepository;
import com.codegym.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService {
    @Autowired
   private IFormRepository iFormRepository;

    @Override
    public void save(Form form) {
        this.iFormRepository.save(form);
    }
}
