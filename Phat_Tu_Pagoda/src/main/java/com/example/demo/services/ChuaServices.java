package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.chuas;
import com.example.demo.respository.IChuasRespo;

@Service
public class ChuaServices implements IChuaServices {
	
	@Autowired 
	private IChuasRespo chuasRespo;

	@Override
	public Page<chuas> getAllChuas(Integer page, Integer size) {
		
		Pageable pageable = PageRequest.of(page, size);
		return this.chuasRespo.findAll(pageable);
	}

	@Override
	public void AddChua(chuas chua) {
		this.chuasRespo.save(chua);
		
	}


	@Override
	public void Delete(Integer chua_id) {
		this.chuasRespo.deleteById(chua_id);
		
	}

	@Override
	public chuas Update(chuas chua_new) {
		Optional<chuas> chua = this.chuasRespo.findById(chua_new.getChua_id());
		if(chua.isEmpty())
			return null;
		chuas chuaCur = chua.get();
		chuaCur.setDiaChi(chua_new.getDiaChi());
		chuaCur.setCapNhat(chua_new.getCapNhat());
		chuaCur.setNgayThanhLap(chua_new.getNgayThanhLap());
		chuaCur.setTenChua(chua_new.getTenChua());
		chuaCur.setTrutri(chua_new.getTrutri());
		
		this.chuasRespo.save(chuaCur);
		
		return chuaCur;
	}
	
	

}
