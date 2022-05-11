package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name like :namevVal",
            countQuery = "select * from product where name like :namevVal", nativeQuery = true)
    Page<Product> findAndSearch(@Param("nameVal") String nameVal, Pageable pageable);
}
