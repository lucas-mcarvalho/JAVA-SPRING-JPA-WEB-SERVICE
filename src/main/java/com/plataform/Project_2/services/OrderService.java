package com.plataform.Project_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataform.Project_2.entities.Order;
import com.plataform.Project_2.repositories.OrderRepository;
@Service	
public class OrderService {

	@Autowired
	private OrderRepository Order;
	
	public List<Order> findAll(){
		return Order.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = Order.findById(id);
		return obj.get();
	}
}
