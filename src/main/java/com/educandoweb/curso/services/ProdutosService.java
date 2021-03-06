package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Produtos;
import com.educandoweb.curso.entities.dto.OrderDTO;
import com.educandoweb.curso.entities.dto.ProdutoDTO;
import com.educandoweb.curso.repositories.ProdutosRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class ProdutosService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private ProdutosRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os usuarios do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<ProdutoDTO> buscarTodos() {
		List<Produtos> produtos = repository.findAll();
		List<ProdutoDTO> dtos = produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).collect(Collectors.toList());
		return dtos;
	}

	public ProdutoDTO buscarPorId(Long id) {
		Optional<Produtos> obj = repository.findById(id);
		ProdutoDTO produto = modelMapper.map(obj.get(), ProdutoDTO.class);
		return produto;
//  o get do optional vai retornar o objeto do tipo usuario que estiver dentro do optional
	}
}
