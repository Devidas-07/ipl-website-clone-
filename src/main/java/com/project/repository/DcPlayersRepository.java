package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.DcPlayers;

@Repository
public interface DcPlayersRepository extends JpaRepository<DcPlayers, Integer>{
		
}
