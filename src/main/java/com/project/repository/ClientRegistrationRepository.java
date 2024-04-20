package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.User;

@Repository
public interface ClientRegistrationRepository extends JpaRepository<User, Integer>{

}
