package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PhatTu;
import com.example.demo.respository.IPhatTuRespo;

@Service
public class PhatTuServices implements IPhatTuServices{
	
	@Autowired
	private IPhatTuRespo phatTuRespo;

	@Override
	public List<PhatTu> getAllPhatTu() {
		// TODO Auto-generated method stub
		return this.phatTuRespo.findAll();
	}
	
	public boolean checkEmailExists(String email) {
        return phatTuRespo.existsByEmail(email);
    }

    public boolean checkSoDienThoaiExists(String soDienThoai) {
        return phatTuRespo.existsBySoDienThoai(soDienThoai);
    }

	@Override
	public void DangKy(PhatTu phatTu) {
		phatTuRespo.save(phatTu);
		
	}

	@Override
	public Page<PhatTu> findPaginated(Integer pageNo, Integer pageSize, String sortField, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo-1	, pageSize, sort);
		return this.phatTuRespo.findAll(pageable);
	}

	@Override
	public void Delete(Integer phatTu_id) {
		this.phatTuRespo.deleteById(phatTu_id);;
		
	}

	@Override
	public PhatTu Update(PhatTu phatTu_new) {
		Optional<PhatTu> phatTu = this.phatTuRespo.findById(phatTu_new.getPhat_tu_id());
		
		if(phatTu.isEmpty())
			return null;
		PhatTu phatTuCur = phatTu.get();
		phatTuCur.setAnhChup(phatTu_new.getAnhChup());
		phatTuCur.setChua_id(phatTu_new.getChua_id());
		phatTuCur.setDahoantuc(phatTu_new.getDahoantuc());
		phatTuCur.setEmail(phatTu_new.getEmail());
		phatTuCur.setGioiTinh(phatTu_new.getGioiTinh());
		phatTuCur.setHo(phatTu_new.getHo());
		phatTuCur.setTenDem(phatTu_new.getTenDem());
		phatTuCur.setTen(phatTu_new.getTen());
		phatTuCur.setKieuthanhvienid(phatTu_new.getKieuthanhvienid());
		phatTuCur.setNgayCapNhat(phatTu_new.getNgayCapNhat());
		phatTuCur.setNgayHoanTuc(phatTu_new.getNgayHoanTuc());
		phatTuCur.setNgaySinh(phatTu_new.getNgaySinh());
		phatTuCur.setNgayXuatGia(phatTu_new.getNgayXuatGia());
		phatTuCur.setPassword(phatTu_new.getPassword());
		phatTuCur.setPhapDanh(phatTu_new.getPhapDanh());
		phatTuCur.setRoles(phatTu_new.getRoles());
		
		this.phatTuRespo.save(phatTuCur);
		
		return phatTuCur;
	}
			
	
}
