package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PhatTu;

@Repository
public interface IPhatTuRespo extends JpaRepository<PhatTu, Integer> {
	
	public Boolean existsBySoDienThoai(String soDienThoai);
	public Boolean existsByEmail(String email);
	public PhatTu findByEmail(String email);
	public PhatTu findByEmailOrSoDienThoai(String email, String soDienThoai);
	
	
	

}
