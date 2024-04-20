package com.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.service.CskPlayersService;
@Controller
public class IplController {
	@Autowired
	CskPlayersService service;
	@GetMapping("/")
	public String clientLoginPage() {
		return "clientLoginForm";
	}
	@GetMapping("/home-page")
	public String homePage() {
		return "index";
	}
	@GetMapping("/venue")
	public String venuePage() {
		return "venue";
	}
	@GetMapping("/about")
	public String aboutPage() {
		return "aboutUs";
	}
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	
}
