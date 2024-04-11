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

import com.project.dto.CskPlayers;
import com.project.dto.Dream11;
import com.project.repository.Dream11Repository;
import com.project.service.CskPlayersService;


@Controller

public class CskPlayersController {
	@Autowired
	CskPlayersService service;
	@Autowired
	Dream11Repository dreamRepo;

	

	@GetMapping("/get-csk-details")
	public ModelAndView getCskDetails() {
		List<CskPlayers> list = service.getCskPlayers();
		return new ModelAndView("PlayerList", "teams", list);
	}
	@PostMapping("/save-csk-players")
	public String saveCskPlayers(@ModelAttribute CskPlayers players) {
		service.saveCskPlayers(players);
		return "redirect:/get-csk-details";
	}

	@GetMapping("/add-csk-players")
	public String addCskPlayers() {
		return "addCskPlayers";
	}

	@RequestMapping("/editPlayer/{id}")
	public String editPlayer(@PathVariable("id") int id, Model model) {
		CskPlayers player = service.getCskPlayerById(id);
		model.addAttribute("player", player);
		return "editPlayer";
	}
	

	@RequestMapping("/delete-player/{id}")
	public String deletePlayer(@PathVariable("id") int id) {
		service.deletePlayerById(id);
		return "redirect:/get-csk-details";
	}

	@GetMapping("/get-csk-by-id/{id}")
	public CskPlayers getById(@PathVariable("id") int id) {
		return service.getCskPlayerById(id);
	}
	@RequestMapping("/add-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		CskPlayers dreamPlayer =service.getCskPlayerById(id);
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
	
	

}
