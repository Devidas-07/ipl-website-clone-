package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.dto.User;
import com.project.service.ClientRegisterService;

@Controller
public class ClientRegisterController {
	@Autowired
	ClientRegisterService service;
	
	@GetMapping("/client-register-page")
	public String getRegisterForm() {
		return "registerForm";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		service.registerUser(user);
		return "redirect:/home-page";
	}
}
