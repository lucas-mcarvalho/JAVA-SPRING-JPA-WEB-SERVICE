package com.plataform.Project_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataform.Project_2.entities.Category;
import com.plataform.Project_2.repositories.CategoryRepository;
@Service	
public class CategoryService {

	@Autowired
	private CategoryRepository Category;
	
	public List<Category> findAll(){
		return Category.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = Category.findById(id);
		return obj.get();
	}
}
