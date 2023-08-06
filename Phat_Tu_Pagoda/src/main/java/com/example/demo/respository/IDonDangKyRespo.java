package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.dondangkys;

@Repository
public interface IDonDangKyRespo extends JpaRepository<dondangkys, Integer> {

}
