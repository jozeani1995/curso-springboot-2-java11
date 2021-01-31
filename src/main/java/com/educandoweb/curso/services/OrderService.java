package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class OrderService {

	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private OrderRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os orders do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<Order> buscarTodos() {
		return repository.findAll();
	}

	public Order buscarPorId(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
//  o get do optional vai retornar o objeto do tipo order que estiver dentro do optional
	}
}
