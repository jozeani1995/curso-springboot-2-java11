package com.educandoweb.curso.entities.dto;

public class CategoryDTO {

	private String name;
	
	private CategoryDTO() {
	}

	public CategoryDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
