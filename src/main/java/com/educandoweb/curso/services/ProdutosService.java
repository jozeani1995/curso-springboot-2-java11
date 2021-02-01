package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Produtos;
import com.educandoweb.curso.repositories.ProdutosRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class ProdutosService {

	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private ProdutosRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os usuarios do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<Produtos> buscarTodos() {
		return repository.findAll();
	}

	public Produtos buscarPorId(Long id) {
		Optional<Produtos> obj = repository.findById(id);
		return obj.get();
//  o get do optional vai retornar o objeto do tipo usuario que estiver dentro do optional
	}
}
