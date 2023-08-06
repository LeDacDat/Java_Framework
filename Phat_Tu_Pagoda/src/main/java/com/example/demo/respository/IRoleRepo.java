package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {

}
