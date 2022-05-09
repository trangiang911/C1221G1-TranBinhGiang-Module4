package com.codegym.services;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> FindAll();

    void save(Music music);

    Music findById(Integer id);

    void update(Music music);

    void delete(Music music);
}
