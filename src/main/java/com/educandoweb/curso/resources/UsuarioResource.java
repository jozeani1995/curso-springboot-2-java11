package com.educandoweb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
// caminho do recurso
public class UsuarioResource {

	@GetMapping
//	responseEntity = respostas de requisições web
	public ResponseEntity<Usuario> buscarTodos(){
		Usuario u = new Usuario(1L, "bob", "bob@gmail.com", "123", "555555");
//		ok = resposta positiva 
//		body = mostrar o corpo instanciado do usuario com os dados
		return ResponseEntity.ok().body(u);
	}
}
