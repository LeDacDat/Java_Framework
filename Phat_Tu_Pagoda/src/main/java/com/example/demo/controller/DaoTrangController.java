package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DaoTrangs;
import com.example.demo.entity.chuas;
import com.example.demo.services.ChuaServices;
import com.example.demo.services.DaoTrangServices;

@RestController
@RequestMapping("/dao-trang")
public class DaoTrangController {


	@Autowired
	private DaoTrangServices daoTrangServices;
	
	@GetMapping("/getAll")
	
	 public ResponseEntity<List<DaoTrangs>> getALlDaoTrangs(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        Page<DaoTrangs> daoTrangPage = daoTrangServices.getAllDaoTrangs(page, size);
	        List<DaoTrangs> daoTrangList = daoTrangPage.getContent();

	        if (daoTrangList.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(daoTrangList, HttpStatus.OK);
	        }
	    }
	
	@PostMapping("/add")
	public String addDaoTrang(@RequestBody DaoTrangs daoTrang) {
		this.daoTrangServices.addDaoTrang(daoTrang);
		return "dao-trang";		
	}
	
	@PutMapping("/update")
	public String updateDaoTrang(@RequestBody DaoTrangs daoTrang_update, Model model) {
		this.daoTrangServices.Update(daoTrang_update);
		model.addAttribute("success!", "Update thành công!");
		return "update-dao-trang";
	}
	
	@DeleteMapping("/delete")
	public String deleteChua(@RequestParam Integer id) {
		this.daoTrangServices.Delete(id);
		return "dao-trang";
	}
}
