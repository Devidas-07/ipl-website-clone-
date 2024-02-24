package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.RcbPlayers;
import com.project.repository.RcbPlayersRepository;

@Controller
public class RcbPlayersController {
	
	@Autowired
	RcbPlayersRepository repo;
	
	@GetMapping("/add-rcb-players")
	public String addRcbPlayers() {
			return "addRcbPlayers";
	}
	@PostMapping("/save-rcb-players")
	public String saveRcbPlayers(@ModelAttribute RcbPlayers rcbplayers) {
		repo.save(rcbplayers);
		return "redirect:/get-rcb-details";
	}
	@GetMapping("/get-rcb-details")
	public ModelAndView getRcbDetails() {
		List<RcbPlayers> list =  repo.findAll();
		return new ModelAndView("PlayerList", "teams",list);
	}
}
