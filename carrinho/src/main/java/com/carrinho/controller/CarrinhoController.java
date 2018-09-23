package com.carrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarrinhoController {

	@Autowired
	RestTemplate template;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("pagamento") + " " + getWord("pedidos") + " " + getWord("produto");
	}

	public String getWord(String service) {
		return template.getForObject("http://" + service, String.class);
	}

}
