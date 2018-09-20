package br.com.improving;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Item;
import br.com.improving.carrinho.Produto;

public class CarrinhoComprasTest {

	Item item;
	
	Produto produto;
	BigDecimal valorUnitario = new BigDecimal("0.0");
	int quantidade = 0;
	
	@Before
	public void criarItem() {
		produto = new Produto(23L, "Primeiro produto");
		quantidade = 3;
		valorUnitario.add(valorUnitario).add(new BigDecimal(100.00));
		
		item = new Item(produto, valorUnitario, quantidade);
	}
	
	@Test
	public void adicionarItemTest(){
		
		CarrinhoCompras carrinho = CarrinhoComprasFactory.criar("255502");
		
		carrinho.adicionarItem(produto, valorUnitario, quantidade);
		
		assertTrue(!carrinho.getItens().isEmpty());
		
	}
	
	@Test
	public void retornarCarrinhoExistenteTest() {
		CarrinhoCompras carrinho = CarrinhoComprasFactory.criar("255502");
		carrinho.adicionarItem(produto, valorUnitario, quantidade);
		
		assertTrue(carrinho.getItens().size() <= 1);
		
	}
	
	@Test
	public void removerItemCarrinhoTest() {
		CarrinhoCompras carrinho = CarrinhoComprasFactory.criar("255502");
		
		carrinho.removerItem(produto);
		
		assertTrue(carrinho.getItens().isEmpty());
		
	}
	
	@Test
	public void getValorTotalTest() {
		CarrinhoCompras carrinho = CarrinhoComprasFactory.criar("255502");
		
		assertTrue(carrinho.getValorTotal().compareTo(valorUnitario) == 0);
	}
}
