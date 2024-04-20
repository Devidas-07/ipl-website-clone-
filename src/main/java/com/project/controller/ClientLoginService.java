package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.User;
import com.project.repository.ClientRegistrationRepository;

@Service
public class ClientLoginService {
	@Autowired
	ClientRegistrationRepository clientRepo;
	public boolean clientValidation(String name, String password) {
		
		List<User> user = clientRepo.findAll();
		for(User u:user) {
			if(u.getName().equals(name) && u.getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
	}
}
