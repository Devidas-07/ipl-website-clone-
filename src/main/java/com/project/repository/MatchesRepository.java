package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.Matches;
@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer>{

}
