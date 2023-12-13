package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.PbksPlayers;

@Repository
public interface PbksPlayersRepository extends JpaRepository<PbksPlayers, Integer>{
		
}
