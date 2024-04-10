package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.dto.Matches;
import com.project.service.MatchesService;

@Controller
public class MatchesController {
	@Autowired
	MatchesService service;
	 @PostMapping("/save-match")
	 public String saveMatches(@ModelAttribute Matches matches) {
		 service.saveMatches(matches);
		 return "redirect:/get-match-details";
		 
	 }
	 @GetMapping("/get-match-details")
	 public String getMatchDetails(Model model) {
		  List<Matches> matches = service.getMatchDetails();
		  model.addAttribute("matches", matches);
		 return "matchList";
	 }
	 @GetMapping("/add-matches")
	 public String addMatches() {
		 return "addMatches";
	 }
}
