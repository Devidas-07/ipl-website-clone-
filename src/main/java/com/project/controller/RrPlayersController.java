package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.RrPlayers;
import com.project.repository.RrPlayersRepository;

@Controller
public class RrPlayersController {
	
	@Autowired
	RrPlayersRepository repo;
	
	@GetMapping("/add-rr-players")
	public String addRrPlayers() {
			return "addRrPlayers";
	}
	@PostMapping("/save-rr-players")
	public String saveRrPlayers(@ModelAttribute RrPlayers rrplayers) {
		repo.save(rrplayers);
		return "redirect:/get-rr-details";
	}
	@GetMapping("/get-rr-details")
	public ModelAndView getRrDetails() {
		List<RrPlayers> list = repo.findAll();
		return new ModelAndView("PlayerList", "teams", list);
	}
}
