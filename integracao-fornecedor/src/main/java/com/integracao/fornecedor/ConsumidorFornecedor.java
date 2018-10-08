package com.integracao.fornecedor;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.integracao.fornecedor.model.Fornecedor;
import com.integracao.fornecedor.repository.IntegracaoFornecedorRepository;

public class ConsumidorFornecedor {

	@Autowired
	IntegracaoFornecedorRepository fornecedorRepository;

	@JmsListener(destination = "fornecedor.read")
	public void receiveMessage(final Message message) throws JMSException {
		String messageData = null;
		System.out.println("Received message " + message);

		Fornecedor fornecedor = null;

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			messageData = textMessage.getText();

			fornecedor = new Fornecedor();
			fornecedor.setRazaoSocial(StringUtils.substring(messageData, 0, 99));
			fornecedor.setNomeFantasia(StringUtils.substring(messageData, 100, 199));
			fornecedor.setCnpj(Long.parseLong(StringUtils.substring(messageData, 200, 299)));
			fornecedor.setLogradouro(StringUtils.substring(messageData, 300, 399));
			fornecedor.setNumero(Integer.parseInt(StringUtils.substring(messageData, 400, 408)));
			fornecedor.setComplemento(StringUtils.substring(messageData, 649, 658));
			fornecedor.setBairro(StringUtils.substring(messageData, 659, 668));
			fornecedor.setCep(Long.parseLong(StringUtils.substring(messageData, 669, 677)));
			fornecedor.setCidade(StringUtils.substring(messageData, 678, 697));
			fornecedor.setEstado(StringUtils.substring(messageData, 698, 700));
			fornecedor.setAtivo(Boolean.parseBoolean(StringUtils.substring(messageData, 701, 705)));

			fornecedorRepository.save(fornecedor);

		}
	}

}
