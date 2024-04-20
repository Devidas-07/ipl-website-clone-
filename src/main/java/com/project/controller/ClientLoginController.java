package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientLoginController {
	@Autowired
	ClientLoginService service;
	
	@PostMapping("/client-login")
	public String login(@RequestParam("name")String name,@RequestParam("password")String password) {
		
		boolean isUserMatch = service.clientValidation(name, password);
		if(isUserMatch) {
			return "redirect:/home-page";
		}
		else {
			return "redirect:/";
		}
	}
}
