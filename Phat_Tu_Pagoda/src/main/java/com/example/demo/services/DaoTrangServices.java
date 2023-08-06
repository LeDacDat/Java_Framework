package com.example.demo.services;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DaoTrangs;
import com.example.demo.respository.IDaoTrangRespo;

@Service
public class DaoTrangServices implements IDaoTrangServices {
	 
	@Autowired
	private IDaoTrangRespo daoTrangRespo;
	
	@Override
	public Page<DaoTrangs> getAllDaoTrangs(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return this.daoTrangRespo.findAll(pageable);
	}

	@Override
	public void addDaoTrang(DaoTrangs daoTrangs) {
		this.daoTrangRespo.save(daoTrangs);
		
	}

	@Override
	public void Delete(Integer dao_trang_id) {
		this.daoTrangRespo.deleteById(dao_trang_id);
		
	}

	@Override
	public DaoTrangs Update(DaoTrangs dao_trang_new) {
		Optional<DaoTrangs> daoTrang = this.daoTrangRespo.findById(dao_trang_new.getDao_trang_id());
		if(daoTrang.isEmpty())
			return null;
		DaoTrangs daoTrangCur = daoTrang.get();
		daoTrangCur.setDaKetThuc(dao_trang_new.getDaKetThuc());
		daoTrangCur.setNguoiTruTri(dao_trang_new.getNguoiTruTri());
		daoTrangCur.setNoiDung(dao_trang_new.getNoiDung());
		daoTrangCur.setNoiToChuc(dao_trang_new.getNoiToChuc());
		daoTrangCur.setSoTVThamGia(dao_trang_new.getSoTVThamGia());
		daoTrangCur.setThoiGianToChuc(dao_trang_new.getThoiGianToChuc());
		
		this.daoTrangRespo.save(daoTrangCur);
		return daoTrangCur;
	}

}
