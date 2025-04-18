package com.plataform.Project_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Project2Application {

	public static void main(String[] args) {

		SpringApplication.run(Project2Application.class, args);

	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}


}
