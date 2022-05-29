package com.codegym.service.impl;

import com.codegym.repository.IAttachRepository;
import com.codegym.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachService implements IAttachService<AttachService> {
    @Autowired
    IAttachRepository iAttachRepository;

    @Override
    public List<com.codegym.model.contract.AttachService> findAll() {
        return iAttachRepository.findAll();
    }
}
