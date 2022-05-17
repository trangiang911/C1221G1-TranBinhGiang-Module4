package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value="select * from product where name like :nameVal",
    countQuery="select * from product where name like :nameVal",nativeQuery=true)
    Page<Product> findAndSearch(String nameVal, Pageable pageable);
}
