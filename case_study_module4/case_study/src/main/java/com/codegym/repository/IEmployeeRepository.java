package com.codegym.repository;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="select * from employee where employee_name like :nameVal and  employee_address like :addressBy and position_id like :positionBy",
    countQuery="select * from employee where employee_name like :nameVal and  employee_address like :addressBy and position_id like :positionBy",nativeQuery=true)
    Page<Employee> findAndSearch(String nameVal, String addressBy, String positionBy, Pageable pageable);
}
