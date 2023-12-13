package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class LsgPlayersController {
	
	
	

	@GetMapping("/add-csk-players")
	public String addCskPlayers() {
		return "addCskPlayers";
	}
	
	
	

}
