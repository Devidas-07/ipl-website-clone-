package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.Dream11;
import com.project.repository.Dream11Repository;

@Controller
public class Dream11Controllere {
@Autowired
Dream11Repository dreamRepo;

@GetMapping("/get-dream11")
public ModelAndView getDream11() {
	List<Dream11> dream11 = dreamRepo.findAll();
	return new ModelAndView("dream11","dream11",dream11);
}
}
