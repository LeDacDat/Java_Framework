package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.PhatTu;

public interface IPhatTuServices {
	
	public List<PhatTu> getAllPhatTu();
	
	public void DangKy(PhatTu phatTu);
	
	Page<PhatTu>  findPaginated(Integer pageNo , Integer pageSize, String sortField, String sortDir);
	
	public void Delete(Integer phatTu_id);
	
	public PhatTu Update(PhatTu phatTu_new);
	
	
}
