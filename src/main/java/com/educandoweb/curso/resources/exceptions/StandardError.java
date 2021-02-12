package com.educandoweb.curso.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
// ==> dados retirados do postMan da parte de erro
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private Integer status;
	private String erro;
	private String messagem;
	private String caminho;
	

	public StandardError() {
	}


	public StandardError(Instant timestamp, Integer status, String erro, String messagem, String caminho) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.messagem = messagem;
		this.caminho = caminho;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getErro() {
		return erro;
	}


	public void setErro(String erro) {
		this.erro = erro;
	}


	public String getMessagem() {
		return messagem;
	}


	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}


	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
