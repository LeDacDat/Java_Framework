package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.respository.IRoleRepo;

@Service
public class RoleServices {
	
	@Autowired
	private IRoleRepo roleRepo;
	
	public Role getRoleById(Long roleID) {
		return roleRepo.findById(roleID).orElse(null);
	}

}
