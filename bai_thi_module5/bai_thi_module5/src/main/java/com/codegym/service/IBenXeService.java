package com.codegym.service;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBenXeService<BenXe> {


    void createBenXe(com.codegym.model.BenXe benXe);

    com.codegym.model.BenXe findBenXeById(Integer id);

    void delete(Integer id);

    List<com.codegym.model.BenXe> findAndSearch(String criterionVal, String valueSearchVal);
}
