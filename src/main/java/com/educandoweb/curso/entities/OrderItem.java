package com.educandoweb.curso.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.curso.entities.primaryKey.OrderItemPrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPrimaryKey id = new OrderItemPrimaryKey();
	 
	private Integer quantidade;
	private Double preco;
	
	public OrderItem() {
	}

	public OrderItem(Order order, Produtos produtos, Integer quantidade, Double preco) {
		super();
		id.setOrder(order);
		id.setProdutos(produtos);
		this.quantidade = quantidade;
		this.preco = preco;
	}
// este conceito e importante
//	o get e o set order e produto estao indo no id do OrderItemPrimaryKey id, e trazendo tudo pra dentro dele.

	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	@JsonIgnore
	public Produtos getProdutos() {
		return id.getProdutos();
	}
	
	public void setProdutos(Produtos produtos) {
		id.setProdutos(produtos);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
