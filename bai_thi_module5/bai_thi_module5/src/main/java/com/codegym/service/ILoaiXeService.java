package com.codegym.service;

import com.codegym.model.LoaiXe;

import java.util.List;

public interface ILoaiXeService<LoaiXe> {
    List<com.codegym.model.LoaiXe> findAll();
}
