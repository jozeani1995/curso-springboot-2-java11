package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repositories.UsuarioRepository;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundExceptions;

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
		return obj.orElseThrow(() -> new ResourceNotFoundExceptions(id));
//  o .get do optional vai retornar o objeto do tipo usuario que estiver dentro do optional(ecessao 500)
	}
	
//	==> inserir um usuario no banco de dados / resource
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
//	==> deletar usuario por id
	public void delete (Long id) {
		repository.deleteById(id);
//	==> resolucao basica
	} 
	
	public Usuario update(Long id, Usuario obj) {
//	==> prepara um objeto monitorado para dps vc realizar uma opercao com o banco de dados
		Usuario entity = repository.findById(id).get();
		updateData(entity, obj);
		return repository.save(entity);
		
	}
//  ==> passando os objetos que serao atualizados
	private void updateData(Usuario entity, Usuario obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setphone(obj.getphone());
	}
}
