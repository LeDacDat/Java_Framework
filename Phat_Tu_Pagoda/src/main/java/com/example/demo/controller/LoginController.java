package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.respository.IPhatTuRespo;
import com.example.demo.services.LoginServices;

@RestController
@RequestMapping(path = "/phat-tu/login")
public class LoginController {
	
	@Autowired
	private LoginServices loginServices;
	
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	//xu ly dang nhap
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		boolean isXacThuc = loginServices.xacThuc(email, password);
		if(isXacThuc) {
			return "redirect:/home";
		}
		else {
			model.addAttribute("Error!", "Đăng nhập không thành công!");
			return "login";
		}
		
	}
	
	@GetMapping("/doi-mat-khau")
	public String showDoiMatKhauForm() {
		return "doi-mat-khau";
	}
	//xu ly doi mat khau
	 @PostMapping("/doi-mat-khau")
	  public String doiMatKhau(@RequestParam("phatTuId") int phatTuId, @RequestParam("newPassword") String newPassword, Model model) {
	        loginServices.doiMatKhau(phatTuId, newPassword);
	        return "redirect:/dang-nhap";
	   }
	 
	 @GetMapping("/quen-mat-khau")
	    public String showQuenMatKhauForm() {
	        return "quen-mat-khau";
	    }

	    // Xử lý quên mật khẩu
	    @PostMapping("/quen-mat-khau")
	    public String quenMatKhau(@RequestParam("emailOrSoDienThoai") String emailOrSoDienThoai, Model model) {
	        boolean isSent = loginServices.guiMaXacNhan(emailOrSoDienThoai);
	        if (isSent) {
	            model.addAttribute("success", "Mã xác nhận đã được gửi");
	        } else {
	            model.addAttribute("error", "Không thể gửi mã xác nhận");
	        }
	        return "quen-mat-khau";
	    }

}
