package com.plataform.Project_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataform.Project_2.entities.OrderItem;
import com.plataform.Project_2.entities.pk.OrderItemPK;

public interface  OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
