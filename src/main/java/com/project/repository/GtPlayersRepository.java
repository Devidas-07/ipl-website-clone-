package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.GtPlayers;

@Repository
public interface GtPlayersRepository extends JpaRepository<GtPlayers, Integer>{
		
}
