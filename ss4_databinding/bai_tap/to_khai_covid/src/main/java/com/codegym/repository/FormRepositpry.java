package com.codegym.repository;

import com.codegym.model.Form;

public class FormRepositpry implements IFormRepository {
    private Form form1=new Form();
    @Override
    public Form save(Form form) {
        return this.form1=form;
    }
}
