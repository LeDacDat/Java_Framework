package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PhatTu;
import com.example.demo.respository.IPhatTuRespo;

@Service
public class LoginServices {
	
	@Autowired
	private IPhatTuRespo phatTuRespo;
	
	public boolean xacThuc(String email, String password) {
		PhatTu phatTu = phatTuRespo.findByEmail(email);
		if(phatTu != null && phatTu.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public void doiMatKhau(Integer phatTuId, String newPassWord) {
		PhatTu phatTu = phatTuRespo.findById(phatTuId).orElse(null);
		
		if(phatTu != null) {
			phatTu.setPassword(	newPassWord);
			phatTuRespo.save(phatTu);
		}
	}
	
	public boolean guiMaXacNhan(String emailOrSoDienThoai) {
       PhatTu phatTu = phatTuRespo.findByEmailOrSoDienThoai(emailOrSoDienThoai, emailOrSoDienThoai);
        if (phatTu != null) {
            // Gửi mã xác nhận đến email hoặc số điện thoại
            // Code gửi mã xác nhận ở đây
            return true;
        }
        return false;
    }
}
