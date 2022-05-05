package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService<E> {
    List<E> findAll();

    void save(Music music);
}
