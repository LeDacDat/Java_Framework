package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PhatTu;
import com.example.demo.entity.Role;
import com.example.demo.services.PhatTuServices;
import com.example.demo.services.RoleServices;

@RestController
@RequestMapping(path = "/phat-tu")
public class PhatTuController {
	
	@Autowired
	private PhatTuServices phatTuServices;
	@Autowired
	private RoleServices roleServices;
	
	@GetMapping(path = "/getAll")
	public List<PhatTu> getAllPhatTu(){
		return phatTuServices.getAllPhatTu();
	}
	
		@PostMapping(path = "/dang-ky")
	public String dangKyPhatTu(PhatTu phatTu,@RequestParam ("roleID") Long roleID ,Model model) {
		boolean existsEmail = phatTuServices.checkEmailExists(phatTu.getEmail());
		boolean existsSoDienThoai = phatTuServices.checkSoDienThoaiExists(phatTu.getSoDienThoai());
		
		if(existsEmail || existsSoDienThoai) {
			model.addAttribute("Error!", "Tài Khoản Đã Tồn Tại!");
			return "dang-ky";
		}
		Role role = roleServices.getRoleById(roleID);
		phatTu.getRoles().add(role);
		phatTuServices.DangKy(phatTu);
		return "redirect:/ dang-nhap";
	}
	
	@GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") Integer pageNo,
    		@RequestParam("sortField") String sortField,
    		@RequestParam("sortDir") String sortDir,
    		Model model) {
        Integer pageSize = 5;
        Page<PhatTu> phatTuPage = phatTuServices.findPaginated(pageNo, pageSize,sortField,sortDir);
        List<PhatTu> phatTuList = phatTuPage.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", phatTuPage.getTotalPages());      
        model.addAttribute("phatTuList", phatTuList);
        
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?"desc":"asc");

        return "home";
    }
	
	@DeleteMapping("/delete")
	public String deletePhatTu(@RequestParam Integer phatTu_id) {
		this.phatTuServices.Delete(phatTu_id);
		return "redirect:/home";
	}
	
	@PutMapping("/update/{id}")
	public String updatePhatTu(@RequestBody PhatTu phatTu_update, Model model) {
		this.phatTuServices.Update(phatTu_update);
		model.addAttribute("success", "Cập nhật thành công!");
		return "update-phat-tu";
	}
	
}
