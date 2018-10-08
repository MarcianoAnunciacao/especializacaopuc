package com.integracao.fornecedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.integracao.fornecedor.model.Fornecedor;

public interface IntegracaoFornecedorRepository extends MongoRepository<Fornecedor, String>{

}
