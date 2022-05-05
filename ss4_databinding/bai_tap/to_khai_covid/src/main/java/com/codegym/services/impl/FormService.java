package com.codegym.services.impl;

import com.codegym.model.Form;
import com.codegym.repository.FormRepositpry;
import com.codegym.repository.IFormRepository;
import com.codegym.services.IFormSerive;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormSerive {
    IFormRepository iFormRepository=new FormRepositpry();
    @Override
    public Form save(Form form) {
        return iFormRepository.save(form);
    }
}
