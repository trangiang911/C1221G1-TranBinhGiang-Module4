package com.codegym.repository;

import com.codegym.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService,Integer> {
}
