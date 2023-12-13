package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.MiPlayers;

@Repository
public interface MiPlayersRepository extends JpaRepository<MiPlayers, Integer>{
		
}
