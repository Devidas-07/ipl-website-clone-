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
import com.project.dto.LsgPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.LsgPlayersRepository;

@Controller
//@RestController
public class LsgPlayersController {
	
	@Autowired
	LsgPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	@GetMapping("/add-lsg-players")
	public String addLsgPlayers() {
		return "addLsgPlayers";
	}
	@PostMapping("/save-lsg-players")
	public String saveLsgPlayers(@ModelAttribute LsgPlayers LsgPlayers) {
		repository.save(LsgPlayers);
		return "redirect:/get-lsg-details";
	}
	@GetMapping("/get-lsg-details")
	public ModelAndView getLsgDetails() {
		List<LsgPlayers> list =  repository.findAll();
		return new ModelAndView("playerListForClient", "players", list);
	}
	@RequestMapping("/edit-lsg-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		LsgPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editLsgPlayer";
	}
	@RequestMapping("/delete-lsg-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-lsg-details";
	}
	@RequestMapping("/add-lsg-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		LsgPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
	
	
	
	

}
