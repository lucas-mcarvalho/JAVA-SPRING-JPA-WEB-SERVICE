package com.plataform.Project_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataform.Project_2.entities.Product;

public interface  ProductRepository extends JpaRepository<Product,Long>{

}
