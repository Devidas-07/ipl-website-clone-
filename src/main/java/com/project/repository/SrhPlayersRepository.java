package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.SrhPlayers;

@Repository
public interface SrhPlayersRepository extends JpaRepository<SrhPlayers, Integer>{
		
}
