package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILibraryService<Library> {
    Page<Library> findAndSearch(String nameVal, Pageable pageable);

    Book findById(Integer id);

    String borrow(Book book);

    void plusAmount(Book book);
}
