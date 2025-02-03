package com.plataform.Project_2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.plataform.Project_2.entities.Category;
import com.plataform.Project_2.entities.Order;
import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.entities.enums.OrderStatus;
import com.plataform.Project_2.repositories.CategoryRepository;
import com.plataform.Project_2.repositories.OrderRepository;
import com.plataform.Project_2.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private OrderRepository Order;
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryrepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null,"Lucas","lucasggtyy358@gmail.com","9999999","2020");
		User u2 = new User(null,"Bruce","Bruce@gmail.com","88888","1010");
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		
		userrepository.saveAll(Arrays.asList(u1,u2));
		Order.saveAll(Arrays.asList(o1));
		
		
	}

}
