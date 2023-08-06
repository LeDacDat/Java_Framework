package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.chuas;

public interface IChuaServices {
	
	public Page<chuas> getAllChuas(Integer page, Integer size);
	
	public void AddChua(chuas chua);
	
	public void Delete(Integer chua_id);
	
	public chuas Update(chuas chua_new);
}
