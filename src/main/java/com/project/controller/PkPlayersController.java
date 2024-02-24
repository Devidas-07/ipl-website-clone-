package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.PbksPlayers;
import com.project.repository.PbksPlayersRepository;

@Controller
public class PkPlayersController {
	
	@Autowired
	PbksPlayersRepository repo;
	
	
	@GetMapping("/add-pk-players")
	public String addPkPlayers() {
			return "addPkPlayers";
	}
	@PostMapping("/save-pk-players")
	public String savePkPlayers(@ModelAttribute PbksPlayers PbksPlayers) {
		repo.save(PbksPlayers);
		return "redirect:/get-pk-details";
	}
	@GetMapping("/get-pk-details")
	public ModelAndView getPkDetails() {
		List<PbksPlayers> list =  repo.findAll();
		return new ModelAndView("PlayerList","teams",list);
	}
}
