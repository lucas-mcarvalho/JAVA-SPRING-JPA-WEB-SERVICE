package com.plataform.Project_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.repositories.UserRepository;
@Service	
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	public List<User> findAll(){
		return userrepository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = userrepository.findById(id);
		return obj.get();
	}
}
