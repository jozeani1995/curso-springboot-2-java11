package com.educandoweb.curso.entities.primaryKey;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Produtos;

@Embeddable
//classe auxiliar de chave composta
//uma reutilizavel
public class OrderItemPrimaryKey implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	criar uma referencia para o produto e outra para o pedido
	@ManyToOne
	@JoinColumn(name = "Order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "Produtos_id")
	private Produtos produtos;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
		OrderItemPrimaryKey other = (OrderItemPrimaryKey) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
	
	
}
