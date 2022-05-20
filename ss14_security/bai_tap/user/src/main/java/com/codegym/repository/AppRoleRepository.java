package com.codegym.repository;

import java.util.List;


import com.codegym.model.AppRole;
import com.codegym.model.AppUser;
import com.codegym.model.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AppRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
