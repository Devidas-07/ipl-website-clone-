package com.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dto.CskPlayers;

@Repository
public interface CskPlayersRepository extends JpaRepository<CskPlayers, Integer>{
	@Autowired
	
	@Query(value=" select * from csk_players INNER JOIN teams WHERE csk_players.teams_tid = teams.tid;", nativeQuery =true)
	public List<Object> getCskDetails();
}
