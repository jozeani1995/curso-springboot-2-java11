package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
