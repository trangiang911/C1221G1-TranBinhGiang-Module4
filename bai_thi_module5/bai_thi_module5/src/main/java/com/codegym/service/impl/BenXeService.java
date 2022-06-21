package com.codegym.service.impl;

import com.codegym.model.BenXe;
import com.codegym.repository.IBenXeRepository;
import com.codegym.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenXeService implements IBenXeService<BenXe> {
    @Autowired
    IBenXeRepository iBenXeRepository;
}
