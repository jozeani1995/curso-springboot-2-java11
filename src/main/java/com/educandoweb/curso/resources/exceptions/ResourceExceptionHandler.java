package com.educandoweb.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.curso.services.exceptions.ResourceNotFoundExceptions;

// --> clase que faz tratamento manualmente

// intercepta as excessoes para que esse objeto possa executar um possivel tratamneto
@ControllerAdvice
public class ResourceExceptionHandler {

//	--> anotation @ExceptionHandler que imtercepta a requisicao e ela cai direto aqui
//	==> ecessao personalizada da ecessao notfoundexception
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundExceptions e, HttpServletRequest request){
	String error = "Resource not Found"; 
	HttpStatus status =  HttpStatus.NOT_FOUND;
	StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	return ResponseEntity.status(status).body(erro);
	}
}
