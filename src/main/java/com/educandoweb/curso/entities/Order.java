package com.educandoweb.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.educandoweb.curso.entities.enums.OrderStatusEnum;
import com.educandoweb.curso.services.Pagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatusEnum;

	@ManyToOne 
	@JoinColumn(name = "usuario_id")
//	joincolumn quer dizer que na tabela de pedidos do BD vou ter uma chave estrangeira chamada 
//	usuario_id que ira conter o id do usuario associado ao pedido
	private Usuario usuario;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
 
//	--> usar o cascade em caso de OneToOne para assim mapear a duas entidades para ter o mesmo id
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Order() {
	}

	public Order(Long id, Instant moment,OrderStatusEnum orderStatusEnum, Usuario usuario) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatusEnum (orderStatusEnum);
		this.usuario = usuario;
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
	
	public OrderStatusEnum getOrderStatusEnum() {
		return OrderStatusEnum.valueOf(orderStatusEnum);
	}

	public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
		if (orderStatusEnum != null) {
		this.orderStatusEnum = orderStatusEnum.getCode();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
//	--> items
// meu pedido conhecer o pedido dele
	public Set<OrderItem> getItems() {
		return items;
	}
// --> pagamento	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
// ==> metodo para fazer uma soma de dois subtotais para gerar um total
	 public Double getTotal() {
		 double sum = 0.0;
		 for (OrderItem x : items) {
			 sum += x.getsubTotal();
		 }
		 return sum;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
