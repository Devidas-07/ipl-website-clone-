package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.DcPlayers;
import com.project.repository.DcPlayersRepository;

@Controller
public class DcPlayersController {
@Autowired
DcPlayersRepository repository;
	@GetMapping("/add-dc-players")
	public String addDcPlayers() {
		return "addDcPlayers";
	}
	@PostMapping("/save-dc-players")
	public String saveDcPlayers(@ModelAttribute DcPlayers players) {
		repository.save(players);
		return "redirect:/get-dc-players";
	}
	@GetMapping("/get-dc-players")
	public ModelAndView getDcPlayers() {
		List<DcPlayers> list = repository.findAll();
		return new ModelAndView("PlayerList","players",list);
	}
}
