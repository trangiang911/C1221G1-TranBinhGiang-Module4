package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Code;

public interface ICodeBookService<Code> {
    String getCodeBook(Book book);

    com.codegym.model.Code findByCode(String code);

    void remove(com.codegym.model.Code code);
}
