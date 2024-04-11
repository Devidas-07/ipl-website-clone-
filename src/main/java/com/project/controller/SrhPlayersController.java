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
import com.project.dto.SrhPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.SrhPlayersRepository;

@Controller
public class SrhPlayersController {
	
	@Autowired
	SrhPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	@GetMapping("/add-srh-players")
	public String addSrhPlayers() {
			return "addSrhPlayers";
	}
	@PostMapping("/save-srh-players")
	public String saveSrhPlayers(@ModelAttribute SrhPlayers srhplayers) {
		repository.save(srhplayers);
		return "redirect:/get-srh-details";
	}
	@GetMapping("/get-srh-details")
	public ModelAndView getSrhDetails() {
		List<SrhPlayers> list =  repository.findAll();
		return new ModelAndView("srhPlayerList", "teams", list);
	}
	@RequestMapping("/edit-srh-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		SrhPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editSrhPlayer";
	}
	@RequestMapping("/delete-srh-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-srh-details";
	}
	@RequestMapping("/add-srh-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		SrhPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
}
