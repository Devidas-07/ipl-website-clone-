package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.Teams;
import com.project.service.TeamsService;

@Controller
public class TeamsController {
	@Autowired
	TeamsService service;
	
	@PostMapping("/save-teams")
	public String saveTeams(@RequestBody Teams teams) {
		service.saveTeams(teams);
		return "team";
	}
	@GetMapping("/team")
	public String teamPage() {
		return "team";
	}
}
