package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.LsgPlayers;
import com.project.repository.LsgPlayersRepository;

@Controller
//@RestController
public class LsgPlayersController {
	
	@Autowired
	LsgPlayersRepository repo;
	
	@GetMapping("/add-lsg-players")
	public String addLsgPlayers() {
		return "addLsgPlayers";
	}
	@PostMapping("/save-lsg-players")
	public String saveLsgPlayers(@ModelAttribute LsgPlayers LsgPlayers) {
		repo.save(LsgPlayers);
		return "redirect:/get-lsg-details";
	}
	@GetMapping("/get-lsg-details")
	public ModelAndView getLsgDetails() {
		List<LsgPlayers> list =  repo.findAll();
		return new ModelAndView("PlayerList", "teams", list);
	}

	
	
	
	

}
