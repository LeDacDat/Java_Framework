package com.example.demo.services;

import org.hibernate.mapping.List;

import com.example.demo.entity.dondangkys;

public interface IDonDangKyServices {
	
	public java.util.List<dondangkys>  getAllDonDangKy();
	
	 public dondangkys getDonDangKyById(int donDangKyId);
	 
	 public dondangkys saveDonDangKy(dondangkys donDangKy);
	 
	 
  
}
