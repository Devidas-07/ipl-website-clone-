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
import com.project.dto.PbksPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.PbksPlayersRepository;

@Controller
public class PkPlayersController {
	
	@Autowired
	PbksPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	
	@GetMapping("/add-pk-players")
	public String addPkPlayers() {
			return "addPkPlayers";
	}
	@PostMapping("/save-pk-players")
	public String savePkPlayers(@ModelAttribute PbksPlayers PbksPlayers) {
		repository.save(PbksPlayers);
		return "redirect:/get-pk-details";
	}
	@GetMapping("/get-pk-details")
	public ModelAndView getPkDetails() {
		List<PbksPlayers> list =  repository.findAll();
		return new ModelAndView("pkPlayerList","teams",list);
	}
	@RequestMapping("/edit-pk-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		PbksPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editPkPlayer";
	}
	@RequestMapping("/delete-pk-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-pk-details";
	}
	@RequestMapping("/add-pk-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		PbksPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
}
