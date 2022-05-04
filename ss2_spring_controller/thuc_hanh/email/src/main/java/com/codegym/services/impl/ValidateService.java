package com.codegym.services.impl;

import com.codegym.services.IValidateService;
import org.springframework.stereotype.Service;

@Service
public class ValidateService implements IValidateService {
    private static final String REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";
    @Override
    public boolean validate(String email) {
        return email.matches(REGEX);
    }
}
