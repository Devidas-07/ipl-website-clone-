package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.dto.Teams;
import com.project.service.TeamsService;

@Controller
public class TeamsController {
	@Autowired
	TeamsService service;
	
	@PostMapping("/save-teams")
	public String saveTeams(@ModelAttribute Teams teams) {
		service.saveTeams(teams);
		return "team";
	}
	@GetMapping("/add-team")
	public String addTeams() {
		return "addTeams";
	}
	@GetMapping("/team")
	public String teamPage() {
		return "team";
	}
	
	/*
	public ModelAndView getTeams() {
		List<Teams> list = service.getTeams();
		return new ModelAndView(list)
	}
	 */
}
