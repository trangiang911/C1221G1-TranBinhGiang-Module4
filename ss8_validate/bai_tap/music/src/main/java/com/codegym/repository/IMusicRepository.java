package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    @Query(value = "select * from music where name like :nameVal",
            countQuery = "select * from music where name like :nameVal", nativeQuery = true)
    Page<Music> findAndSearch(String nameVal, Pageable pageable);
}
