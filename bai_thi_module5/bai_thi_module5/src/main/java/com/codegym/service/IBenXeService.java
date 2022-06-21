package com.codegym.service;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBenXeService<BenXe> {
    Page<com.codegym.model.BenXe> findAndSearch(String loaiXeVal, String tenNhaXeVal, Pageable pageable);

    void createBenXe(com.codegym.model.BenXe benXe);

    com.codegym.model.BenXe findBenXeById(Integer id);

    void delete(Integer id);
}
