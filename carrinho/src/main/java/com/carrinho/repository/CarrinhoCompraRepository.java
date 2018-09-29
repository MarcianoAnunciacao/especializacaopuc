package com.carrinho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carrinho.model.CarrinhoCompra;

public interface CarrinhoCompraRepository extends MongoRepository<CarrinhoCompra, String> {

	public CarrinhoCompra findByIdentificacaoCliente(String identificacaoCliente);

}