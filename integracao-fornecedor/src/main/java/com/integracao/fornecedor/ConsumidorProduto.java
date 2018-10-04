package com.integracao.fornecedor;

import java.math.BigDecimal;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.integracao.fornecedor.model.Categoria;
import com.integracao.fornecedor.model.Fornecedor;
import com.integracao.fornecedor.model.Produto;

@Component
public class ConsumidorProduto {

	@JmsListener(destination = "produto.read")
	public void receiveMessage(final Message message) throws JMSException {
		String messageData = null;
		Produto produto = null;
		Categoria categoria = null;
		Fornecedor fornecedor = null;

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			messageData = textMessage.getText();

			produto = new Produto();
			produto.setNome(StringUtils.substring(messageData, 0, 99));
			produto.setDescricao(StringUtils.substring(messageData, 100, 199));
			produto.setValor(new BigDecimal(StringUtils.substring(messageData, 200, 211)));
			produto.setQuantidade(Integer.parseInt(StringUtils.substring(messageData, 212, 220)));

			categoria = new Categoria();
			categoria.setNome(StringUtils.substring(messageData, 221, 320));
			produto.setCategoria(categoria);

			produto.setAtivo(Boolean.valueOf(StringUtils.substring(messageData, 321, 326)));

			fornecedor = new Fornecedor();
			fornecedor.setRazaoSocial(StringUtils.substring(messageData, 327, 426));
			fornecedor.setNomeFantasia(StringUtils.substring(messageData, 427, 526));
			fornecedor.setCnpj(Long.parseLong(StringUtils.substring(messageData, 527, 541)));
			fornecedor.setLogradouro(StringUtils.substring(messageData, 542, 641));
			fornecedor.setNumero(Integer.parseInt(StringUtils.substring(messageData, 642, 648)));
			fornecedor.setComplemento(StringUtils.substring(messageData, 649, 658));
			fornecedor.setBairro(StringUtils.substring(messageData, 659, 668));
			fornecedor.setCep(Long.parseLong(StringUtils.substring(messageData, 669, 677)));
			fornecedor.setCidade(StringUtils.substring(messageData, 678, 697));
			fornecedor.setEstado(StringUtils.substring(messageData, 698, 700));
			fornecedor.setAtivo(Boolean.parseBoolean(StringUtils.substring(messageData, 701, 705)));

			produto.setFornecedor(fornecedor);

			String fornecedorResourceUrl = "http://localhost:8001/produtos";

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Produto> request = new HttpEntity<>(produto);
			
			ResponseEntity<Produto> response = restTemplate.exchange(fornecedorResourceUrl, HttpMethod.POST, request,
					Produto.class);

			
			/*
			 * @GetMapping("/someMapping") public String
			 * someMethod(@RequestHeader("Authorization") String token) {
			 * 
			 * } Now you can place the token within the header for the following request:
			 * 
			 * HttpHeaders headers = new HttpHeaders(); headers.set("Authorization", token);
			 * 
			 * HttpEntity<RestRequest> entityReq = new HttpEntity<RestRequest>(request,
			 * headers); Now you can pass the HttpEntity to your rest template:
			 * 
			 * template.exchange("RestSvcUrl", HttpMethod.POST, entityReq,
			 * SomeResponse.class);
			 */

			
			System.out.println("Resposta do cadastramento de Produto : " + response.getStatusCodeValue());
		}
	}

}
