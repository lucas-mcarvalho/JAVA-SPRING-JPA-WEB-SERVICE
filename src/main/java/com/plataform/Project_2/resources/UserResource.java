package com.plataform.Project_2.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataform.Project_2.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
		
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User (1L,"Bruce","asilo@gmail.com","9999","4040");
		return ResponseEntity.ok().body(u);
	}
	
	
}
