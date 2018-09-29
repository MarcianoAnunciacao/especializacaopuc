package com.carrinho.model;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoCompra {

	private List<Item> itens = new LinkedList<>();
	
	private String identificacaoCliente;

	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}

	public void setIdentificacaoCliente(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	
}
