package com.educandoweb.curso.entities.dto;

import java.util.HashSet;
import java.util.Set;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.OrderItem;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private String descrição;
	private Double price;
	private String imgUrl;
	
	private Set<CategoryDTO> categorias;
	
	private ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, String descrição, Double price, String imgUrl,
			Set<CategoryDTO> categorias) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
		this.price = price;
		this.imgUrl = imgUrl;
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<CategoryDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<CategoryDTO> categorias) {
		this.categorias = categorias;
	}
	
}
