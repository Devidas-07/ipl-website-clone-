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
import com.project.dto.RrPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.RrPlayersRepository;

@Controller
public class RrPlayersController {
	
	@Autowired
	RrPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	
	@GetMapping("/add-rr-players")
	public String addRrPlayers() {
			return "addRrPlayers";
	}
	@PostMapping("/save-rr-players")
	public String saveRrPlayers(@ModelAttribute RrPlayers rrplayers) {
		repository.save(rrplayers);
		return "redirect:/get-rr-details-for-admin";
	}
	@GetMapping("/get-rr-details")
	public ModelAndView getRrDetails() {
		List<RrPlayers> list = repository.findAll();
		return new ModelAndView("playerListForClient", "players", list);
	}
	@GetMapping("/get-rr-details-for-admin")
	public ModelAndView getRrDetailsForAdmin() {
		List<RrPlayers> list = repository.findAll();
		return new ModelAndView("playerListForAdmin", "players", list);
	}
	@RequestMapping("/edit-rajasthan-royals-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		RrPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editRrPlayer";
	}
	@RequestMapping("/delete-rajasthan-royals-player-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-rr-details";
	}
	@RequestMapping("/add-rajasthan-royals-player-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		RrPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}

}
