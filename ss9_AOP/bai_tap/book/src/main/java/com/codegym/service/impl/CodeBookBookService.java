package com.codegym.service.impl;

import com.codegym.model.Code;
import com.codegym.model.Book;
import com.codegym.repository.ICodeBookRepository;
import com.codegym.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookBookService implements ICodeBookService<Code> {
    @Autowired
    ICodeBookRepository iCodeBookRepository;

    @Override
    public String getCodeBook(Book book) {
//        double randomDouble = Math.random();
//        randomDouble = randomDouble * 100000 + 1;
        int codeBorrow = (int)(Math.floor(Math.random()*1000) + 9999);
        String random = Integer.toString(codeBorrow);
        Code code=new Code(random, book);
        this.iCodeBookRepository.save(code);
        return code.getCode();
    }

    @Override
    public Code findByCode(String code) {
        return this.iCodeBookRepository.findByCode(code);
    }

    @Override
    public void remove(Code code) {
        this.iCodeBookRepository.delete(code);
    }
}
