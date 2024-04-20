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
import com.project.dto.KkrPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.KkrPlayersRepository;

@Controller
public class KkrPlayersController {
	@Autowired
	KkrPlayersRepository repository;
	@Autowired
	Dream11Repository dreamRepo;
	@GetMapping("/add-kkr-players")
	public String addKkrPlayers() {
			return "addKkrPlayers";
	}
	
	@PostMapping("/save-kkr-players")
	public String saveKkrPlayers(@ModelAttribute KkrPlayers KkrPlayers) {
		repository.save(KkrPlayers);
		return "redirect:/get-kkr-details";
	}
	
	@GetMapping("/get-kkr-details")
	public ModelAndView getKkrDetails() {
		List<KkrPlayers> list = repository.findAll();
		return new ModelAndView("playerListForClient","players",list);
	}
	@RequestMapping("/edit-kolkata-knight-riders-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		KkrPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editKkrPlayer";
	}
	@RequestMapping("/delete-kkr-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-kkr-details";
	}
	@RequestMapping("/add-kkr-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		KkrPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
}
