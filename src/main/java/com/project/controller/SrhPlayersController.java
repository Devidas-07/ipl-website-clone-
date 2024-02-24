package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.SrhPlayers;
import com.project.repository.SrhPlayersRepository;

@Controller
public class SrhPlayersController {
	
	@Autowired
	SrhPlayersRepository repo;
	
	@GetMapping("/add-srh-players")
	public String addSrhPlayers() {
			return "addSrhPlayers";
	}
	@PostMapping("/save-srh-players")
	public String saveSrhPlayers(@ModelAttribute SrhPlayers srhplayers) {
		repo.save(srhplayers);
		return "redirect:/get-srh-details";
	}
	@GetMapping("/get-srh-details")
	public ModelAndView getSrhDetails() {
		List<SrhPlayers> list =  repo.findAll();
		return new ModelAndView("PlayerList", "teams", list);
	}
}
