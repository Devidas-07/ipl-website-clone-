package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.Dream11Repository;

@Service
public class Dream11Service {
	@Autowired
	Dream11Repository repo;
	
	

}
