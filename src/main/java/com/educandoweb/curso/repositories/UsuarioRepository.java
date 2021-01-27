package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Usuario;

// classe responsavel por operações com a entity usuario

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
