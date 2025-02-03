package com.plataform.Project_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataform.Project_2.entities.Product;
import com.plataform.Project_2.repositories.ProductRepository;
@Service	
public class ProductService {

	@Autowired
	private ProductRepository Product;
	
	public List<Product> findAll(){
		return Product.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = Product.findById(id);
		return obj.get();
	}
}
