package com.codegym.repository;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBenXeRepository extends JpaRepository<BenXe,Integer> {
    @Query(value = "select * from ben_xe where id_loai_xe like :loaiXeVal and ten_nha_xe like :s",
    countQuery = "select * from ben_xe where id_loai_xe like :loaiXeVal and ten_nha_xe like :s", nativeQuery= true)
    Page<BenXe> findAndSearch(String loaiXeVal, String s, Pageable pageable);
}
