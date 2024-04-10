package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.controller.CskPlayersController;

@SpringBootApplication
public class IplWebsiteCloneApplication {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(IplWebsiteCloneApplication.class, args);
		
		CskPlayersController m=ctx.getBean(CskPlayersController.class);
		m.addCskPlayers();
	}

}
