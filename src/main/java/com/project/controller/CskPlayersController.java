package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.CskPlayers;
import com.project.repository.CskPlayersRepository;
import com.project.service.CskPlayersService;

//@RestController
@Controller

public class CskPlayersController {
	@Autowired
	CskPlayersService service;
	@Autowired
	CskPlayersRepository repository;
	
@PostMapping("/save-csk-players")
public String saveCskPlayers(@ModelAttribute CskPlayers players) {
	service.saveCskPlayers(players);
	return "redirect:/get-csk-details";
	
}

@GetMapping("/get-csk-details")
public ModelAndView getCskDetails() {
 List<CskPlayers> list = service.getCskPlayers();
	return new ModelAndView("PlayerList", "teams", list);
}

/*
@GetMapping("/get-csk-details")
public List<CskPlayers> getCskDetails() {
 return service.getCskPlayers();
	
}
*/


@GetMapping("/add-csk-players")
public String addCskPlayers() {
		return "addCskPlayers";
}


}
