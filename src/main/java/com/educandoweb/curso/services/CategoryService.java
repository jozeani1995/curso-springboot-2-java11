package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class CategoryService {

	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private CategoryRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os usuarios do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<Category> buscarTodos() {
		return repository.findAll();
	}

	public Category buscarPorId(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
//  o get do optional vai retornar o objeto do tipo usuario que estiver dentro do optional
	}
}
