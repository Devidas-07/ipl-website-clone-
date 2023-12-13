package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.CskPlayers;
import com.project.repository.CskPlayersRepository;
import com.project.service.CskPlayersService;

//@Controller
@RestController
public class CskPlayersController {
	@Autowired
	CskPlayersService service;
	@Autowired
	CskPlayersRepository repository;
	
	@PostMapping("/save-csk-players")
	public String saveCskPlayers(@ModelAttribute CskPlayers players) {
		service.saveCskPlayers(players);
		return "redirect:/get-csk-players-restapi";
		
	}
	@GetMapping("/get-csk-players")
	public ModelAndView getCskPlayers() {
		List<CskPlayers> list = service.getCskPlayers();
		
		return new ModelAndView("PlayerList", "players", list);
		
	}

	@GetMapping("/add-csk-players")
	public String addCskPlayers() {
		return "addCskPlayers";
	}
	/*@GetMapping("get-csk-players-restapi")
	public ModelAndView getCskPlayersWithRestApi(){
		List<Object> list = service.getCskPlayersWithJoin();
		return new ModelAndView("PlayerList","players", list);
	}*/
	
	
	
	
	
	
	/*@GetMapping("get-csk-players-restapi")
	public List<Object> getCskPlayersWithRestApi(){
		return service.getCskPlayersWithJoin();
		
	}*/
	

}
