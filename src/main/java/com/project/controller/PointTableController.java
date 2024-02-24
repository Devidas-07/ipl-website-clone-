package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.PointTable;
import com.project.service.PointTableService;

@Controller
public class PointTableController {
	@Autowired
	PointTableService service;
	@GetMapping("/get-point-table")
	public String getPointTable() {
		return "updatePointTable";
	}
	@PostMapping("/update-point-table")
	public String updatePointTable(@ModelAttribute PointTable point) {
		service.updatePointTable(point);
		return "pointTable";
	}
	@GetMapping("/point_table")
	public ModelAndView pointTablePage() {
		List<PointTable>list = service.getPointTable();
		return new ModelAndView("pointTable","pointTable",list);
	}
}
