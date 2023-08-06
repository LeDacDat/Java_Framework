package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.dondangkys;
import com.example.demo.respository.IDonDangKyRespo;

@Service
public class DonDangKyServices implements IDonDangKyServices{
	
	@Autowired
	private IDonDangKyRespo donDangKyRespo;

	@Override
	public List<dondangkys> getAllDonDangKy() {
		  return donDangKyRespo.findAll();
	}

	@Override
	public dondangkys getDonDangKyById(int donDangKyId) {
		 return donDangKyRespo.findById(donDangKyId).orElse(null);
	}

	@Override
	public dondangkys saveDonDangKy(dondangkys donDangKy) {
		 return donDangKyRespo.save(donDangKy);
	}
	
}
