package com.produto.model;

import org.springframework.data.annotation.Id;

public class Categoria {
	
	public Categoria() {}
	
	@Id
	private String id;
	
	private String nome;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
}
