package com.pagamento.controller;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pagamento.model.CarrinhoCompraConverter;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="carrinho")
public interface CarrinhoPagamentoProxy {

	@GetMapping("carrinho/{identificacaoCliente}")
	public CarrinhoCompraConverter selecionarCarrinho(@PathVariable String identificacaoCliente);
	
	@GetMapping("carrinho/{identificacaoCliente}/valorTotalCompras")
	public BigDecimal selecionarValorTotalCarrinho(@PathVariable String identificacaoCliente);
	
	@DeleteMapping("carrinho")
	public void deletarCarrinho(@RequestBody CarrinhoCompraConverter carrinho);
	
	
}
