package com.codegym.service;

import java.util.List;

public interface IPositionService<Position> {
    List<Position> findAll();
}
