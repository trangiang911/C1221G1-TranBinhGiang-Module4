package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value="select * from customer where customer_name like :nameVal and customer_address like :addressBy and customer_type_id like :typeBy",
    countQuery="select * from customer where customer_name like :nameVal and customer_address like :addressBy and customer_type_id like :typeBy" ,nativeQuery=true)
    Page<Customer> findAndSearch(String nameVal,String addressBy,String typeBy, Pageable pageable);
}
