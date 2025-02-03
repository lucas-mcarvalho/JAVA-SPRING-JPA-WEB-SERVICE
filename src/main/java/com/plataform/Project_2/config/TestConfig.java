package com.plataform.Project_2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.plataform.Project_2.entities.Order;
import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.entities.enums.OrderStatus;
import com.plataform.Project_2.repositories.OrderRepository;
import com.plataform.Project_2.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private OrderRepository Order;
	@Override
	public void run(String... args) throws Exception {
		
		
		
		User u1 = new User(null,"Lucas","lucasggtyy358@gmail.com","9999999","2020");
		User u2 = new User(null,"Bruce","Bruce@gmail.com","88888","1010");
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		
		userrepository.saveAll(Arrays.asList(u1,u2));
		Order.saveAll(Arrays.asList(o1));
		
	}

}
