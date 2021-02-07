package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Produtos;
import com.educandoweb.curso.entities.dto.OrderDTO;
import com.educandoweb.curso.entities.dto.ProdutoDTO;
import com.educandoweb.curso.repositories.OrderRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class OrderService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private OrderRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os orders do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<OrderDTO> buscarTodos() {
		List<Order> orders = repository.findAll();
		List<OrderDTO> dtos = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
		return dtos;
	}

	public OrderDTO buscarPorId(Long id) {
		Optional<Order> obj = repository.findById(id);
		OrderDTO dto = modelMapper.map(obj.get(), OrderDTO.class);
		return dto;
//  o get do optional vai retornar o objeto do tipo order que estiver dentro do optional
	}
}
