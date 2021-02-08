package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.OrderItem;
import com.educandoweb.curso.entities.Produtos;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.entities.enums.OrderStatusEnum;
import com.educandoweb.curso.repositories.CategoryRepository;
import com.educandoweb.curso.repositories.OrderItemRepository;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.ProdutosRepository;
import com.educandoweb.curso.repositories.UsuarioRepository;
import com.educandoweb.curso.services.Pagamento;

// indica que este é uma classe de configuração @Configuration
@Configuration
@Profile("teste")
// para especificar que esta classe é especifica para o perfil de teste 
public class TesteConfig implements CommandLineRunner {

	@Autowired
//	o spring resolve a dependencia e associa uma instancia de user repository aqui dentro
	private UsuarioRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
//	tudo que estiver dentro do metodo run vai ser executado quando a aplicação for iniciada
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Produtos p1 = new Produtos(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produtos p2 = new Produtos(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produtos p3 = new Produtos(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produtos p4 = new Produtos(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produtos p5 = new Produtos(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
//      salvar no banco de dados
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtosRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
//		qual categoria pertence a um determinado produto
//		fazendo uma ssociacao entre objetos
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
//		salvar no banco de dados:
		produtosRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "123", "111111111");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "456", "22222222");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatusEnum.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatusEnum.WAINTING_PAIMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatusEnum.WAINTING_PAIMENT, u1);

//		mandar salvar no banco de dados:
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

//		  item de pedido =(pedido, produto, quantidade, preco(reproduzindo o preco do p1, p2 etc..)  
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
//		salvar no banco
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
//		==> dados(Long id, Instant moment, Order order)
		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		
//		==> salvamento de um objeto dependente com uma relacao OneToOne
		o1.setPagamento(pag1);
		
		orderRepository.save(o1);
		

	}

}
