package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	@GetMapping("/admin-login-page")
	public String getAdminLoginPage() {
		return "adminLoginForm";
	}
	@PostMapping("/admin-login")
	public String adminLogin(@RequestParam("name")String name,@RequestParam("password")String password) {
		boolean admin= service.adminValidation(name, password);
		if(admin) {
			return "admin";
		}
		return "redirect:/admin-login-page";
	}
}
