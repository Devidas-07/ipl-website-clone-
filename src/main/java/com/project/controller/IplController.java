package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.PointTable;
import com.project.service.MiPlayersService;
import com.project.service.PointTableService;

@Controller
public class IplController {
	
	@Autowired
	PointTableService pointservice;
	
	@Autowired
	MiPlayersService miplayerservice;
	
	

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	

	@GetMapping("/point_table")
	public ModelAndView pointTablePage() {
		List<PointTable>list = pointservice.getPointTable();
		return new ModelAndView("pointTable","pointTable",list);
	}
	/*@GetMapping("/check")
	public List<PointTable> check(){
		return pointtableservice.getPointTable();
	}*/

	@GetMapping("/venue")
	public String venuePage() {
		return "venue";
	}

	@GetMapping("/about")
	public String aboutPage() {
		return "aboutUs";

	}

//	@GetMapping("/csk_players")
//	public ModelAndView getplayers() {
//		List<Players> list = iplservice.getPlayers();
//		return new ModelAndView("Player", "players", list);
//	}
//	@GetMapping("/mi_players")
//	public ModelAndView getMiPlayers() {
//		List<MiPlayers> list = miplayerservice.getMiPlayers();
//		return new ModelAndView("miPlayerList", "players", list);
//	}
	

	

	


}
