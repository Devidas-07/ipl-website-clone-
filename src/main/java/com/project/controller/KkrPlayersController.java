package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.KkrPlayers;
import com.project.repository.KkrPlayersRepository;

@Controller
public class KkrPlayersController {
	@Autowired
	KkrPlayersRepository repo;
	
	@GetMapping("/add-kkr-players")
	public String addKkrPlayers() {
			return "addKkrPlayers";
	}
	/*
	 * @GetMapping("/get-csk-details")
public ModelAndView getCskDetails() {
 List<CskPlayers> list = service.getCskPlayers();
	return new ModelAndView("PlayerList", "teams", list);
}
	 */
	
	@PostMapping("/save-kkr-players")
	public String saveKkrPlayers(@ModelAttribute KkrPlayers KkrPlayers) {
		repo.save(KkrPlayers);
		return "redirect:/get-kkr-details";
	}
	
	@GetMapping("/get-kkr-details")
	public ModelAndView getKkrDetails() {
		List<KkrPlayers> list = repo.findAll();
		return new ModelAndView("PlayerList","teams",list);
	}
}
