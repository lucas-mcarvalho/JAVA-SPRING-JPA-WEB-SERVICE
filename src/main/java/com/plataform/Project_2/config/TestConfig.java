package com.plataform.Project_2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.plataform.Project_2.entities.Category;
import com.plataform.Project_2.entities.Order;
import com.plataform.Project_2.entities.OrderItem;
import com.plataform.Project_2.entities.Product;
import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.entities.enums.OrderStatus;
import com.plataform.Project_2.repositories.CategoryRepository;
import com.plataform.Project_2.repositories.OrderItemRepository;
import com.plataform.Project_2.repositories.OrderRepository;
import com.plataform.Project_2.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productrepository; 
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Games");
		
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Elden ring PS4", "Cras fringilla convallis sem vel faucibus.", 249.99, "");
		
		categoryrepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		productrepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat4);
		
		
		productrepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null,"Lucas","lucasggtyy358@gmail.com","9999999","2020");
		User u2 = new User(null,"Bruce","Bruce@gmail.com","88888","1010");
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID, u2);
		
		userrepository.saveAll(Arrays.asList(u1,u2));
		Order.saveAll(Arrays.asList(o1,o2));
		
		OrderItem oi1 = new OrderItem(o1, p5, 2, p5.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2));
		
	}

}
