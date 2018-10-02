package com.pagamento.model;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoCompraConverter {

	private List<ItemConverter> itens = new LinkedList<>();
	
	private String identificacaoCliente;

	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}

	public void setIdentificacaoCliente(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}

	public List<ItemConverter> getItens() {
		return itens;
	}

	public void setItens(List<ItemConverter> itens) {
		this.itens = itens;
	}

	
}
