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
import com.project.dto.GtPlayers;
import com.project.repository.Dream11Repository;
import com.project.repository.GtPlayersRepository;

@Controller
//@RestController
public class GtPlayersController {
@Autowired
GtPlayersRepository repository;
@Autowired
Dream11Repository dreamRepo;
	@GetMapping("/add-gt-players")
	public String addGtPlayers() {
		return "addGtPlayers";
	}
	@PostMapping("/save-gt-players")
	public String saveGtPlayers(@ModelAttribute GtPlayers players) {
		repository.save(players);
		return "redirect:/get-gt-details";
	}
	
	@GetMapping("/get-gt-details")
	public ModelAndView getGtPlayers() {
		List<GtPlayers> list = repository.findAll();
		return new ModelAndView("gtPlayerList","teams",list);
	}
	@RequestMapping("/edit-gt-player/{id}")
	public String editPlayer(@PathVariable("id")int id, Model model) {
		GtPlayers player = repository.findById(id).get();
		model.addAttribute("player", player);
		return "editGtPlayer";
	}
	@RequestMapping("/delete-gt-player/{id}")
	public String deletePlayer(@PathVariable("id")int id) {
		repository.deleteById(id);
		return "redirect:/get-gt-details";
	}
	@RequestMapping("/add-gt-to-dream11/{id}")
	public String addToDream11(@PathVariable("id") int id) {
		GtPlayers dreamPlayer=repository.findById(id).get();
		
		Dream11 dream11= new Dream11(dreamPlayer.getId(), dreamPlayer.getPlayerName(), dreamPlayer.getRoll(), dreamPlayer.getNation(), dreamPlayer.getTeams());
		dreamRepo.save(dream11);
		return "redirect:/get-dream11";
	}

}
