package com.educandoweb.curso.services.exceptions;

// --> classe para tratamento excessoes
public class ResourceNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptions(Object id) {
		super("Resource Not Found. id " + id);
	}
}
