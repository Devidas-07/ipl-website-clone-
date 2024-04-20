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

import com.project.dto.DcPlayers;
import com.project.dto.Dream11;
import com.project.repository.DcPlayersRepository;
import com.project.repository.Dream11Repository;

@Controller
public class DcPlayersController {
@Autowired
DcPlayersRepository repository;
@Autowired
Dream11Repository dreamRepo;
	@GetMapping("/add-dc-players")
	public String addDcPlayers() {
		return "addDcPlayers";
	}
	@PostMapping("/save-dc-players")
	public String saveDcPlayers(@ModelAttribute DcPlayers players) {
		repository.save(players);
		return "redirect:/get-dc-details-for-admin";
	}
	@GetMapping("/get-dc-details")
	public ModelAndView getDcPlayers() {
		List<DcPlayers> list = repository.findAll();
		return new ModelAndView("playerListForClient","players",list);
	}
	@GetMapping("/get-dc-details-for-admin")
	public ModelAndView getDcPlayersForAdmin() {
		List<DcPlayers> list = repository.findAll();
		return new ModelAndView("playerListForAdmin","players",list);
	}
	@RequestMapping("/edit-delhi-capitals-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		DcPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editDcPlayer";
	}
	@RequestMapping("/delete-delhi-capitals-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-dc-details";
	}
	@RequestMapping("/add-delhi-capitals-player-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		DcPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}
	@GetMapping("/dc-venue")
	public String getDcStadiumDetails() {
		return "dcVenue";
	}
}
