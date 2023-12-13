package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.LsgPlayers;

@Repository
public interface LsgPlayersRepository extends JpaRepository<LsgPlayers, Integer>{
		
}
