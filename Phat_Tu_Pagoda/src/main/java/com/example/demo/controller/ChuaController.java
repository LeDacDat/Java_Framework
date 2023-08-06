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

import com.example.demo.entity.chuas;
import com.example.demo.services.ChuaServices;

@RestController
@RequestMapping("/chua")
public class ChuaController {
	
	@Autowired
	private ChuaServices chuaServices;
	
	@GetMapping("/getAll")
	
	 public ResponseEntity<List<chuas>> getAllChuas(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        Page<chuas> chuaPage = chuaServices.getAllChuas(page, size);
	        List<chuas> chuaList = chuaPage.getContent();

	        if (chuaList.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(chuaList, HttpStatus.OK);
	        }
	    }
	
	@PostMapping("/add")
	public String addChua(@RequestBody chuas chua) {
		this.chuaServices.AddChua(chua);
		return "chua";		
	}
	
	@PutMapping("/update")
	public String updateChua(@RequestBody chuas chua_update, Model model) {
		this.chuaServices.Update(chua_update);
		model.addAttribute("success!", "Update thành công!");
		return "update-chua";
	}
	
	@DeleteMapping("/delete")
	public String deleteChua(@RequestParam Integer id) {
		this.chuaServices.Delete(id);
		return "chua";
	}
}
