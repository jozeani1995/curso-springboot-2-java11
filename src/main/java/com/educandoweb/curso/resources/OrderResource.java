package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.dto.OrderDTO;
import com.educandoweb.curso.services.OrderService;

@RestController
@RequestMapping(value = "/order")
// caminho do recurso
public class OrderResource {

	@Autowired
	private OrderService service;

	@GetMapping
//	responseEntity = respostas de requisições web
	public ResponseEntity<List<OrderDTO>> buscarTodos() {
		List<OrderDTO> list = service.buscarTodos();
//chamando a camada serviço (service/ para se usar o service e so colocar uma injecao de dependencia) na operacao do findAll
		return ResponseEntity.ok().body(list);
//ok = resposta positiva 
//body = mostrar o corpo instanciado do usuario com os dados
	}

	@GetMapping(value = "/{id}")
//	indica que a requisicao aceita um id dentro da url
	public ResponseEntity<OrderDTO> buscarPorId(@PathVariable Long id) {
//	para eu conseguir que o spring aceite uma url na requisicao usamos o pathvariable
		OrderDTO obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

}
