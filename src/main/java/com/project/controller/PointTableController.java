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

import com.project.dto.PointTable;
import com.project.service.PointTableService;

@Controller
public class PointTableController {
	@Autowired
	PointTableService service;
	@GetMapping("/add-point-table")
	public String getPointTable() {
		return "updatePointTable";
	}
	@PostMapping("/update-point-table")
	public String updatePointTable(@ModelAttribute PointTable point) {
		service.updatePointTable(point);
		return "redirect:/point_table";
	}
	@GetMapping("/point_table")
	public ModelAndView pointTablePage() {
		List<PointTable>list = service.getPointTable();
		return new ModelAndView("pointTableForClient","pointTable",list);
	}
	@RequestMapping("/update-point-table-by-id/{id}")
	public String updatePointTableById(@PathVariable("id")int id,Model model) {
		PointTable p = service.getPointTableById(id);
		model.addAttribute("point", p);
		return "editPoints";
	}
}
