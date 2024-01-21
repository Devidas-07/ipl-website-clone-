package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CskPlayers;
import com.project.repository.CskPlayersRepository;

@Service
public class CskPlayersService {
	@Autowired
	CskPlayersRepository repository;
	public void saveCskPlayers(CskPlayers players) {
		repository.save(players);
	}
	public List<CskPlayers> getCskPlayers(){
		List<CskPlayers> list= repository.findAll();
		
		return list;
	}
	
	
}
