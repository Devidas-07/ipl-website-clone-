package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Matches;
import com.project.repository.MatchesRepository;

@Service
public class MatchesService {
	@Autowired
	MatchesRepository repo;
	public void saveMatches(Matches matches) {
		repo.save(matches);
	}
	public List<Matches> getMatchDetails(){
		List<Matches> list = repo.findAll();
		return list;
	}
}
