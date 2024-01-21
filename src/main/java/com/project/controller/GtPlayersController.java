package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.GtPlayers;
import com.project.repository.GtPlayersRepository;

@Controller
public class GtPlayersController {
@Autowired
GtPlayersRepository repository;
	@GetMapping("/add-gt-players")
	public String addGtPlayers() {
		return "addGtPlayers";
	}
	@PostMapping("/save-gt-players")
	public String saveGtPlayers(@ModelAttribute GtPlayers players) {
		repository.save(players);
		return "saved";
	}
	@GetMapping("/get-gt-players")
	public ModelAndView getGtPlayers() {
		List<GtPlayers> list = repository.findAll();
		return new ModelAndView("PlayersList","teams",list);
	}
}
