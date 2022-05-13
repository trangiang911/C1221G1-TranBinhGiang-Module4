package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService<Music> {
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAndSearch(String nameVal, Pageable pageable) {
        return this.iMusicRepository.findAndSearch("%"+nameVal+"%",pageable);
    }
}
