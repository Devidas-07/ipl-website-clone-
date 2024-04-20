package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Admin;
import com.project.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepo;
	
	public boolean adminValidation(String name, String password) {
		List<Admin> admin =  adminRepo.findAll();
		for(Admin a:admin) {
			if(a.getName().equals(name)&& a.getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
	}
}
