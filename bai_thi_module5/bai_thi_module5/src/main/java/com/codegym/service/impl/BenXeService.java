package com.codegym.service.impl;

import com.codegym.model.BenXe;
import com.codegym.repository.IBenXeRepository;
import com.codegym.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BenXeService implements IBenXeService<BenXe> {
    @Autowired
    IBenXeRepository iBenXeRepository;

    @Override
    public Page<BenXe> findAndSearch(String loaiXeVal, String tenNhaXeVal, Pageable pageable) {
        return this.iBenXeRepository.findAndSearch(loaiXeVal,"%"+tenNhaXeVal+"%",pageable);
    }

    @Override
    public void createBenXe(BenXe benXe) {
        this.iBenXeRepository.save(benXe);
    }

    @Override
    public BenXe findBenXeById(Integer id) {
        return this.iBenXeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.iBenXeRepository.deleteById(id);
    }
}
