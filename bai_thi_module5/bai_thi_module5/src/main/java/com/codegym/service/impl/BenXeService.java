package com.codegym.service.impl;

import com.codegym.model.BenXe;
import com.codegym.repository.IBenXeRepository;
import com.codegym.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenXeService implements IBenXeService<BenXe> {
    @Autowired
    IBenXeRepository iBenXeRepository;



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

    @Override
    public List<BenXe> findAndSearch(String criterionVal, String valueSearchVal) {
        switch (criterionVal){
            case "1":
                criterionVal = "so_xe";
                break;
            case "2":
                criterionVal = "ten_nha_xe";
                break;
            case "3":
                criterionVal = "sdt";
                break;
            default:
                break;
        }
        System.out.println(criterionVal);
        System.out.println(valueSearchVal);
        return this.iBenXeRepository.findAndSearch(criterionVal,"%"+valueSearchVal+"%");
    }
}
