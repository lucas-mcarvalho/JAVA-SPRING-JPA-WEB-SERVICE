package com.plataform.Project_2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataform.Project_2.entities.Order;
import com.plataform.Project_2.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
		
	@Autowired
	OrderService Order;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = Order.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id){
		Order obj = Order.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}
