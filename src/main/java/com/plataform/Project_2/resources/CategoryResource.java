package com.plataform.Project_2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataform.Project_2.entities.Category;
import com.plataform.Project_2.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
		
	@Autowired
	CategoryService Category;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = Category.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id){
		Category obj = Category.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
