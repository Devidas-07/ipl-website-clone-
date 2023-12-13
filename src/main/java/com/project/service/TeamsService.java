package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Teams;
import com.project.repository.TeamsRepository;

@Service
public class TeamsService {
	@Autowired
	TeamsRepository repository;
	
	public void saveTeams(Teams teams) {
		repository.save(teams);
	}
}
