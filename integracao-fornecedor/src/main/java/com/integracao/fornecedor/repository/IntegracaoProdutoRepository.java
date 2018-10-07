package com.integracao.fornecedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.integracao.fornecedor.model.Produto;

public interface IntegracaoProdutoRepository extends MongoRepository<Produto, String>{

}
