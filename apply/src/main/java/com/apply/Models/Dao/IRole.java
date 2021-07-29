package com.apply.Models.Dao;

import com.apply.Models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole  extends JpaRepository<Role, Long>{
    
    Role findByRole(String role);
}
