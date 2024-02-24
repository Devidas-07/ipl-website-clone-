package com.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IplController {
	@GetMapping("/")
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
