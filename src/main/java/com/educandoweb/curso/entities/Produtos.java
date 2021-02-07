package com.educandoweb.curso.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descrição;
	private Double price;
	private String imgUrl;

// o set representa um conjunto	isso garante que eu não vou ter 
//	mais de um produto com + de uma ocorrencia de mesma categoria
//	o mesmo produto nao pode ter mais de uma categoria
	@ManyToMany
	@JoinTable(name = "tb_produtos_categoria",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
//	no JoinTable vai falar qual vai ser o nome da tabela e quais vao ser 
//	as chaves estrangeiras que vai associar a tabela de produto com a tabela categoria
	private Set<Category> categorias = new HashSet<>();

//	nomes relacionados a classe orderItemprimarykey
//	declarando uma colecao de itens
	@OneToMany(mappedBy = "id.produtos")
	private Set<OrderItem> items = new HashSet<>();
	
	public Produtos() {
	}

	public Produtos(Long id, String nome, String descrição, Double price, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public Set<Category> getCategorias() {
		return categorias;
	}

	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;	
//			: = lista
//		-> estou percurrendo a colecao items do tipo order item associada ao meu produto
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
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
