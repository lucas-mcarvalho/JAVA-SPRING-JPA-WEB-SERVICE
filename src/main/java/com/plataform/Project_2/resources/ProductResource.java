package com.plataform.Project_2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataform.Project_2.entities.Product;
import com.plataform.Project_2.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
		
	@Autowired
	ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Product> products = service.findAll();
		model.addAttribute("products", products); // Passa a lista de produtos para o template
		return "products"; // Nome do template Thymeleaf
	}
	
	
	
}
