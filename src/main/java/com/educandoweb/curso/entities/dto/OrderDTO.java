package com.educandoweb.curso.entities.dto;

import java.time.Instant;
import java.util.List;

import com.educandoweb.curso.entities.OrderItem;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private String orderStatusEnum;
	private UsuarioDTO usuario;
	private List<OrderItemDTO> items;
	
	private OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, String orderStatusEnum, UsuarioDTO usuario, List<OrderItemDTO> items) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatusEnum = orderStatusEnum;
		this.usuario = usuario;
		this.items = items; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getOrderStatusEnum() {
		return orderStatusEnum;
	}

	public void setOrderStatusEnum(String orderStatusEnum) {
		this.orderStatusEnum = orderStatusEnum;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}
	 public Double getTotal() {
		 double sum = 0.0;
		 for (OrderItemDTO x : items) {
			 sum += x.getsubTotal();
		 }
		 return sum;
}
	 }
	 
