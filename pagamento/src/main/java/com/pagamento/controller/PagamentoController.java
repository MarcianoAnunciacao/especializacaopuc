package com.pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pagamento.PagamentoService;
import com.pagamento.model.CarrinhoCompraConverter;
import com.pagamento.model.Pagamento;

@RestController("finalizar")
public class PagamentoController {

	@Autowired
	CarrinhoPagamentoProxy carrinhoProxy;
	
	@Autowired
	PagamentoService service;

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void finalizarPagamento(@RequestBody Pagamento pagamento) {

		CarrinhoCompraConverter carrinho = carrinhoProxy
				.selecionarCarrinho(pagamento.getPessoa().getIdentificacaoCliente());
		
		
		service.finalizarPagamento(pagamento);
		
		carrinhoProxy.deletarCarrinho(carrinho);

	}

}
