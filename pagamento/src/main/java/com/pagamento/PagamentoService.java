package com.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagamento.model.Pagamento;
import com.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	PagamentoRepository repository;
	
	@Transactional
	public void finalizarPagamento(Pagamento pagamento) {
		
		//TODO enviar Pagamento para processadora
		
		//Salvar pagamentos
		repository.save(pagamento);
		
		//TODO enviar para fornecedor
		
		
	}
	
}
