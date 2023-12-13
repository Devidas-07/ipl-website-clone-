package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
