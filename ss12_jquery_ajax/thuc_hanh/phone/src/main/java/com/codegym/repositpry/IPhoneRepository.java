package com.codegym.repositpry;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {
    @Query(value = "select * from phone where model like :modelVal",
            countQuery = "select * from phone where model like :modelVal", nativeQuery = true)
    Page<Phone> findByName(String modelVal, Pageable pageable);
}
