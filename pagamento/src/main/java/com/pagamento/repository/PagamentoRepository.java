package com.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pagamento.model.Pagamento;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {

}
