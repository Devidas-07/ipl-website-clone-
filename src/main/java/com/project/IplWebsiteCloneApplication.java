package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.service.PointTableService;

@SpringBootApplication
public class IplWebsiteCloneApplication {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(IplWebsiteCloneApplication.class, args);
		PointTableService s= ctx.getBean(PointTableService.class);
		s.getPointTable();
		
	}

}
