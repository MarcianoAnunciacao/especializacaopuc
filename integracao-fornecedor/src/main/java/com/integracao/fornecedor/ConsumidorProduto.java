package com.integracao.fornecedor;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.integracao.fornecedor.model.Produto;

@Component
public class ConsumidorProduto {

	@JmsListener(destination = "produto.read")
	public void receiveMessage(@Payload Produto produto, @Headers MessageHeaders headers, Message message,
			Session session) {
		System.out.println(produto.toString());
	}

}
