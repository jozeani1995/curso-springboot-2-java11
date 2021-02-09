package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repositories.UsuarioRepository;

@Service
//registrar sua classe como componente do spring/ @component,@service,@repository
public class UsuarioService {

	@Autowired
//  essa anotacao serve para o spring faca a injeção de dependencia de forma transparente
	private UsuarioRepository repository;
//	declaração de dependencia

//  metodo que retorna todos os usuarios do banco de dados
//  REPASSANDO A CHAMADA PARA MEU REPOSITORY
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
//  o get do optional vai retornar o objeto do tipo usuario que estiver dentro do optional
	}
	
//	==> inserir um usuario no banco de dados / resource
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
		
	}
}
