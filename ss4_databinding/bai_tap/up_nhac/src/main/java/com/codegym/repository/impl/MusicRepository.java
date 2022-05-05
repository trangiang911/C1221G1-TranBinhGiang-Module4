package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository implements IMusicRepository {
    private static List<Music> musicList=new ArrayList<>();
    static {
        musicList.add(new Music("co cò bé bé","Xuân mai","Thiếu nhi","mp3.zing"));
        musicList.add(new Music("co cò bé bé","Xuân mai","Thiếu nhi","mp3.zing"));
        musicList.add(new Music("co cò bé bé","Xuân mai","Thiếu nhi","mp3.zing"));
    }

    @Override
    public List<Music> findAll() {
        return musicList;
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }
}
