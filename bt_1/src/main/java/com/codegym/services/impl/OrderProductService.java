package com.codegym.services.impl;

import com.codegym.models.OrderProduct;
import com.codegym.repository.IOrderProductRepository;
import com.codegym.services.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OrderProductService implements IOrderProductService<OrderProduct> {
    @Autowired
    IOrderProductRepository iOrderProductRepository;

    @Override
    public Page<OrderProduct> findAndSearch(String dateStartBy, String dateEndBy, Pageable pageable) {
        if(dateStartBy.equals("") && dateEndBy.equals("")){
            return this.iOrderProductRepository.findAll(pageable);
        }else if(!dateStartBy.equals("") && !dateEndBy.equals("")){
            return this.iOrderProductRepository.findAllByDateBuyBetween(dateStartBy,dateEndBy,pageable);

        }else if (!dateStartBy.equals("") && dateEndBy.equals("")){
            return this.iOrderProductRepository.findAllByDateBuyAfter(dateStartBy,pageable);
        }else {
            return this.iOrderProductRepository.findAllByDateBuyBefore(dateEndBy,pageable);
        }
    }

    @Override
    public Page<OrderProduct> findTop(Pageable pageable) {
        return this.iOrderProductRepository.findTop(pageable);
    }

    @Override
    public OrderProduct findById(Integer id) {
        return  this.iOrderProductRepository.findById(id).orElse(null);
    }


}
