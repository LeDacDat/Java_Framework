package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.DaoTrangs;


public interface IDaoTrangServices {

	public Page<DaoTrangs> getAllDaoTrangs(Integer page, Integer size);
	
	public void addDaoTrang(DaoTrangs daoTrangs);
	
	public void Delete(Integer dao_trang_id);
	
	public DaoTrangs Update(DaoTrangs dao_trang_new);
	
	
}
