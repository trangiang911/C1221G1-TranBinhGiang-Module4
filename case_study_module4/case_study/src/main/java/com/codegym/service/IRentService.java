package com.codegym.service;

import java.util.List;

public interface IRentService<RentType> {
    List<RentType> findAll();
}
