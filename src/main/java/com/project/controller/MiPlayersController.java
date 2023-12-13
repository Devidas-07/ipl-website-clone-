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
		return "redirect:/mi_players";
	}
	
	
	
	
//	@GetMapping("/mi_players")
//	public ModelAndView getMiPlayers() {
//		List<MiPlayers> list = miRepo.findAll();
//		return new ModelAndView("miPlayerList", "players", list);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/addMiPlayersRest")
//	public String addMiPlayers(@RequestBody MiPlayers miplayers) {
//		miplayersservice.addMiPlayers(miplayers);
//		return "player added succesfully";
//	}

}
