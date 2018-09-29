package com.carrinho.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carrinho.model.CarrinhoCompra;
import com.carrinho.model.Item;
import com.carrinho.repository.CarrinhoCompraRepository;
import com.carrinho.service.CarrinhoCompraService;

@RestController("carrinho")
public class CarrinhoController {

	@Autowired
	CarrinhoCompraService service;
	
	@Autowired
	CarrinhoCompraRepository repository;

	@GetMapping("{identificacaoCliente}")
	public ResponseEntity<CarrinhoCompra> selecionarCarrinhoCompras(@PathVariable String identificacaoCliente) {

		Optional<CarrinhoCompra> carrinho = service.selecionarCarrinho(identificacaoCliente);

		if (carrinho.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(carrinho.get());
		}

	}

	@GetMapping("{identificacaoCliente}/valorTotalCompras")
	public ResponseEntity<BigDecimal> selecionarValorTotalCompras(@PathVariable String identificacaoCliente){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getValorTotal(identificacaoCliente));
		
	}
	
	@GetMapping("{identificacaoCliente}/itensCarrinho")
	public ResponseEntity<Collection<Item>> listarItensCarrinho(@PathVariable String identificacaoCliente){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getItens(identificacaoCliente));
	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody CarrinhoCompra carrinho) {
		repository.save(carrinho);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@RequestBody CarrinhoCompra carrinho) {
		repository.delete(carrinho);
	}
	
	@PutMapping("{identificacaoCliente}/adicionarItem")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void adicionarItemCarrinho(@PathVariable String identificacaoCliente, @RequestBody Item novoItem) {
		
		service.adicionarItem(novoItem, identificacaoCliente);
		
	}
	
	@DeleteMapping("{identificacaoCliente}/removerItem")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarItem(@PathVariable String identificacaoCliente, @RequestBody Item itemARemover) {
		
		service.removerItem(itemARemover, identificacaoCliente);
		
	}
	
	
	
}
