package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.User;
import com.project.repository.ClientRegistrationRepository;

@Service
public class ClientRegisterService {
	@Autowired
	ClientRegistrationRepository repo;
	public void registerUser(User user) {
		repo.save(user);
	}
}
