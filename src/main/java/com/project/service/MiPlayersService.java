package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.MiPlayers;
import com.project.repository.MiPlayersRepository;

@Service
public class MiPlayersService {
	@Autowired
	MiPlayersRepository miplayersrepository;
	public List<MiPlayers> getMiPlayers() {
		List<MiPlayers> list = miplayersrepository.findAll();
		return list;
	}
	public void save(MiPlayers miplayers) {
		miplayersrepository.save(miplayers);
	}
}
