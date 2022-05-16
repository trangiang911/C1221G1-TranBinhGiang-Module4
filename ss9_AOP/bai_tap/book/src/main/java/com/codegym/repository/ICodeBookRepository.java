package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ICodeBookRepository extends JpaRepository<Code,Integer> {
    @Query(value="select * from code where code = :code",nativeQuery=true)
    Code findByCode(String code);
}
