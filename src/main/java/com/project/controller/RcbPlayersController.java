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
import com.project.dto.RcbPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.RcbPlayersRepository;

@Controller
public class RcbPlayersController {
	
	@Autowired
	RcbPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	@GetMapping("/add-rcb-players")
	public String addRcbPlayers() {
			return "addRcbPlayers";
	}
	@PostMapping("/save-rcb-players")
	public String saveRcbPlayers(@ModelAttribute RcbPlayers rcbplayers) {
		repository.save(rcbplayers);
		return "redirect:/get-rcb-details";
	}
	@GetMapping("/get-rcb-details")
	public ModelAndView getRcbDetails() {
		List<RcbPlayers> list =  repository.findAll();
		return new ModelAndView("rcbPlayerList", "teams",list);
	}
	@RequestMapping("/edit-rcb-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		RcbPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editRcbPlayer";
	}
	@RequestMapping("/delete-rcb-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-rcb-details";
	}
	@RequestMapping("/add-rcb-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		RcbPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
}
