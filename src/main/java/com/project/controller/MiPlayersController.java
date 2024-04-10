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
	MiPlayersService service;
	

	@GetMapping("/add-mi-players")
	public String addMiPlayersForm() {
		return "addMiPlayers";			
	}
	@PostMapping("/save-mi-players")
	public String addMiPlayers(@ModelAttribute MiPlayers miPlayers) {
		service.save(miPlayers);
		return "redirect:/mi-team-details";
	}
	@GetMapping("/get-mi-details")
	public ModelAndView getMiTeamDetails() {
		List<MiPlayers> list = service.getMiPlayers();
		return new ModelAndView("PlayerList","teams",list);
	}
//	@RequestMapping("/editPlayer/{id}")
//	public String editMiPlayer(@PathVariable("id")int id, Model model) {
//		MiPlayers player = service.getMiPlayerById(id);
//		model.addAttribute("player",player);
//		return "editPlayer";
//	}


}
