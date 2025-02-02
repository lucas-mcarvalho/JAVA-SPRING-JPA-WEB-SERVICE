package com.plataform.Project_2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Lucas","lucasggtyy358@gmail.com","9999999","2020");
		
		userrepository.saveAll(Arrays.asList(u1));
		
	}

}
