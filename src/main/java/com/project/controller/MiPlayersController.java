package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.MiPlayers;
import com.project.service.MiPlayersService;

@Controller

public class MiPlayersController {
	@Autowired
	MiPlayersService miplayersservice;
	
	@GetMapping("/mi_players")
	public ModelAndView getMiPlayers() {
		List<MiPlayers> list = miplayersservice.getMiPlayers();
		return new ModelAndView("PlayerList", "players", list);
	}
	
	
	@GetMapping("/add")
	public String addMiPlayersForm() {
		return "addMiPlayers";			
	}
	@PostMapping("/add-players")
	public String addMiPlayers(@ModelAttribute MiPlayers miPlayers) {
		miplayersservice.save(miPlayers);
		return "redirect:/mi-team-details";
	}
	@GetMapping("/mi-team-details")
	public ModelAndView getMiTeamDetails() {
		List<MiPlayers> list = miplayersservice.getMiPlayers();
		return new ModelAndView("PlayerList","teams",list);
	}
//	@GetMapping("/mi-team-details")
//	public List<MiPlayers> getMiTeamDetails() {
//		List<MiPlayers> list = miplayersservice.getMiPlayers();
//		return  list;
//	}

}
