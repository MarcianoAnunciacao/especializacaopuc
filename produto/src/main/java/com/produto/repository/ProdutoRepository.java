package com.produto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.produto.model.Categoria;
import com.produto.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

	public List<Produto> findByNome(String nome);
	
	public List<Produto> findByCategoria(Categoria cateria);
	
}