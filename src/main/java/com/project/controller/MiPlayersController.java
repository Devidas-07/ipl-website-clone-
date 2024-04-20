package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.Dream11;
import com.project.dto.MiPlayers;
import com.project.repository.Dream11Repository;
import com.project.service.MiPlayersService;

@Controller

public class MiPlayersController {
	@Autowired
	MiPlayersService service;
	@Autowired
	Dream11Repository dreamRepo;

	@GetMapping("/add-mi-players")
	public String addMiPlayersForm() {
		return "addMiPlayers";			
	}
	@PostMapping("/save-mi-players")
	public String addMiPlayers(@ModelAttribute MiPlayers miPlayers) {
		service.save(miPlayers);
		return "redirect:/get-mi-details";
	}
	@GetMapping("/get-mi-details")
	public ModelAndView getMiTeamDetails() {
		List<MiPlayers> list = service.getMiPlayers();
		return new ModelAndView("playerListForClient","players",list);
	}
	@RequestMapping("/edit-mi-player/{id}")
	public String editPlayer(@PathVariable("id") int id, Model model) {
		MiPlayers player = service.getMiPlayerById(id);
		model.addAttribute("player", player);
		return "editMiPlayer";
	}
	@RequestMapping("/delete-mi-player/{id}")
	public String deletePlayer(@PathVariable("id") int id) {
		service.deleteMiPlayerById(id);
		return "redirect:/get-mi-details";
	}

	@GetMapping("/get-by-id/{id}")
	public MiPlayers getById(@PathVariable("id") int id) {
		return service.getMiPlayerById(id);
	}
	@RequestMapping("/add-mi-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		MiPlayers dreamPlayer =service.getMiPlayerById(id);
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
}
