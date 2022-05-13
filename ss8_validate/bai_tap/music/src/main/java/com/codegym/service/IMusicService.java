package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService<Music> {
    Page<Music> findAndSearch(String nameVal, Pageable pageable);
}
