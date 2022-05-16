package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.ILibraryRepository;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements ILibraryService<Book> {
    @Autowired
    ILibraryRepository iLibraryRepository;

    @Override
    public Page<Book> findAndSearch(String nameVal, Pageable pageable) {
        return this.iLibraryRepository.findAndSearch("%" + nameVal + "%", pageable);
    }

    @Override
    public Book findById(Integer id) {
        return this.iLibraryRepository.findById(id).orElse(null);
    }

    @Override
    public String borrow(Book book) {
        if (book.getAmount() != 0) {
            book.setAmount(book.getAmount() - 1);
            this.iLibraryRepository.save(book);
            return null;
        }else {
            return "Sách trên kệ đã hết";
        }

    }

    @Override
    public void plusAmount(Book book) {
        book.setAmount(book.getAmount() + 1);
        this.iLibraryRepository.save(book);
    }

}
