package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILibraryRepository extends JpaRepository<Book,Integer> {
    @Query(value="select * from library where name like :nameVal",
    countQuery="select * from library where name like :nameVal",nativeQuery=true)
    Page<Book> findAndSearch(String nameVal, Pageable pageable);
}
