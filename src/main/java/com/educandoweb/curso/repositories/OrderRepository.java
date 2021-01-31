package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Order;

// classe responsavel por operações com a entity usuario

public interface OrderRepository extends JpaRepository<Order, Long> {

}
