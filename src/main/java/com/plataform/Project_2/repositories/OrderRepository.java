package com.plataform.Project_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataform.Project_2.entities.Order;

public interface  OrderRepository extends JpaRepository<Order,Long>{

}
