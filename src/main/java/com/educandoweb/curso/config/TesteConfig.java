package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.entities.enums.OrderStatusEnum;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.UsuarioRepository;

// indica que este é uma classe de configuração @Configuration
@Configuration
@Profile("teste")
// pra especificar que esta classe é especifica para o perfil de teste 
public class TesteConfig implements CommandLineRunner {

	@Autowired
//	o spring resolve a dependencia e associa uma instancia de user repository aqui dentro
	private UsuarioRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
//	tudo que estiver dentro do metodo run vai ser executado quando a aplicação for iniciada
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "123", "111111111");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "456", "22222222"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatusEnum.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),  OrderStatusEnum.WAINTING_PAIMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),  OrderStatusEnum.WAINTING_PAIMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
	
	
}
