package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value="select * from product where name like :nameVal and price like :price and category_id like :category" ,
    countQuery="select * from product where name like :nameVal and price like :price and category_id like :category",nativeQuery=true)
    Page<Product> findAndSearch(@Param("nameVal") String nameVal,@Param("category") String categoryFind,@Param("price") String priceFind, Pageable pageable);
}
