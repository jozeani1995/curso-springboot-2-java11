package com.educandoweb.curso.entities.dto;

import java.util.List;

public class OrderItemDTO {

	private Integer quantidade;
	private Double preco;
	private List<ProdutoDTO> produto;
	
	private OrderItemDTO() {
	}

	public OrderItemDTO(Integer quantidade, Double preco, List<ProdutoDTO> items) { 
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = items;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<ProdutoDTO> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoDTO> items) {
		this.produto = items;
	}
	
	
}
