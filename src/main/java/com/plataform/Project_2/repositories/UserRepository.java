package com.plataform.Project_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataform.Project_2.entities.User;
//ESSA CLASSE É RESPONSÁVEL POR GERENCIAR OPERÇÕES NO BANCO DE DADOS SEM ESCREVER SQL
public interface  UserRepository extends JpaRepository<User,Long>{

}
