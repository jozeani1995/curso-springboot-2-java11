package com.educandoweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
// caminho do recurso
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
//	responseEntity = respostas de requisições web
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> list = service.buscarTodos();
//chamando a camada serviço (service/ para se usar o service e so colocar uma injecao de dependencia) na operacao do findAll
		return ResponseEntity.ok().body(list);
		//ok = resposta positiva 
		//body = mostrar o corpo instanciado do usuario com os dados
	}

	@GetMapping(value = "/{id}")
//	indica que a requisicao aceita um id dentro da url
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
//	para eu conseguir que o spring aceite uma url na requisicao usamos o pathvariable
		Usuario obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj); 
	}
	
// end point para inserir um usuario
   @PostMapping
   public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
//==>	chamar o service para executar a opercao de insert que acabei de fazer   
	  obj = service.insert(obj); 
//	  ==> para retornar o metodo created  201 
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	  return ResponseEntity.created(uri).body(obj); 
   }
   
   @DeleteMapping(value = "/{id}")
//   ==>para um long id ser reconhecido como uma variavel da url usa-se pathvariable
   public ResponseEntity<Void> delete(@PathVariable Long id){
	   service.delete(id);
	   return ResponseEntity.noContent().build(); 
   }
   
   @PutMapping(value = "/{id}")
//   ==> atualizando dados de um usuario por id
   public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
	obj = service.update(id, obj);
	return ResponseEntity.ok().body(obj);
   }
      }
   
