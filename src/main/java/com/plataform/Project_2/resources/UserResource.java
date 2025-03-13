package com.plataform.Project_2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.services.UserService;

@RestController//DEFINE OS ENDPOINTS PARA CHAMADA NO BANCO DE DADOS
@RequestMapping(value = "/users")//AO BUSCAR OS ENDPOINTS DESSE TIPO,TODOS COMEÇAM COM "USERS"
public class UserResource {
		
	@Autowired//INJETA AS DEPENDENCIAS NECESSÁRIAS
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		user = service.insert(user);
		//RETORNA A URL DO RECURSO CRIADO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);	
	}
	
	@DeleteMapping(value = "/{id}")//CAPTURA O ID ESPECÍFICO
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user)	{
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);
	}
}
