package com.codegym.repository;

import com.codegym.models.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrderProductRepository extends JpaRepository<OrderProduct,Integer> {
    @Query(value="select * from order_product where date_buy >= :dateStartBy and date_buy <= :dateEndBy",
    countQuery="select * from order_product where date_buy >= :dateStartBy and date_buy <= :dateEndBy",nativeQuery=true)
    Page<OrderProduct> findAndSearch(String dateStartBy, String dateEndBy, Pageable pageable);

    Page<OrderProduct> findAllByDateBuyBetween(String dateStartBy,String dateEndBy, Pageable pageable);
    Page<OrderProduct> findAllByDateBuyAfter(String dateStartBy, Pageable pageable);
    Page<OrderProduct> findAllByDateBuyBefore(String dateEndBy, Pageable pageable);
}
