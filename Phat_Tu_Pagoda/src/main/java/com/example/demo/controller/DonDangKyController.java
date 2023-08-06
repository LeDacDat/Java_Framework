package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.dondangkys;
import com.example.demo.services.DonDangKyServices;

@RestController
@RequestMapping("/don-dang-ky")
public class DonDangKyController {

	@Autowired
    private DonDangKyServices donDangKyService;
	
	@GetMapping("/getAll")
	public List<dondangkys> getALlDonDangKy(){
		return this.donDangKyService.getAllDonDangKy();
	}

    @PostMapping("/duyet-don/{adminId}")
    public ResponseEntity<dondangkys> duyetDon(@PathVariable int adminId, @RequestBody dondangkys donDangKy) {
        dondangkys existingDonDangKy = donDangKyService.getDonDangKyById(donDangKy.getDon_dang_ky_id());
        if (existingDonDangKy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Xử lý duyệt đơn bởi admin
        existingDonDangKy.setTrangThaiDon("Đã duyệt"); // 1: Đã duyệt
        existingDonDangKy.setNguoiXuLy("admin_" + adminId);

        dondangkys updatedDonDangKy = donDangKyService.saveDonDangKy(existingDonDangKy);
        return new ResponseEntity<>(updatedDonDangKy, HttpStatus.OK);
    }
    
    
	
}
