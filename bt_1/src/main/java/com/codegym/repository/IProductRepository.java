package com.codegym.repository;

import com.codegym.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductType_ProductTypeId(Integer id);
}
