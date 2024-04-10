package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.Dream11;
@Repository
public interface Dream11Repository extends JpaRepository<Dream11, Integer>{

}
