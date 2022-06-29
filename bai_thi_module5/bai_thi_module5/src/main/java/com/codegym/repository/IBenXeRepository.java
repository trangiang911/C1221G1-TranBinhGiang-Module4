package com.codegym.repository;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBenXeRepository extends JpaRepository<BenXe,Integer> {
//    @Query(value = "select * from ben_xe where ten_nha_xe like :s",
//    countQuery = "select * from ben_xe where ten_nha_xe like :s", nativeQuery= true)
//    Page<BenXe> findAndSearc(String loaiXeVal, String s, Pageable pageable);

    @Query(value = "call findAndSearch(:criterionVal,:valueSearchVal)",
             nativeQuery= true)
    List<BenXe> findAndSearch(@Param("criterionVal") String criterionVal, @Param("valueSearchVal") String valueSearchVal);
}
