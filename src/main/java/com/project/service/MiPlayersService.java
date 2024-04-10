package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.MiPlayers;
import com.project.repository.MiPlayersRepository;

@Service
public class MiPlayersService {
	@Autowired
	MiPlayersRepository repo;
	
	public List<MiPlayers> getMiPlayers() {
		List<MiPlayers> list = repo.findAll();
		return list;
	}
	public void save(MiPlayers miplayers) {
		repo.save(miplayers);
	}
	public MiPlayers getMiPlayerById(int id) {
		return repo.findById(id).get();
	}
	public void deleteMiPlayerById(int id) {
		repo.deleteById(id);
	}
}
