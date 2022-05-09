package com.codegym.services.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.repository.impl.BaseRepository;
import com.codegym.services.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> FindAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }

    @Override
    public Music findById(Integer id) {
        return this.iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        this.iMusicRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        this.iMusicRepository.delete(music);
    }
}
