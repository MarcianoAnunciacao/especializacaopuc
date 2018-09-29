package com.carrinho.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrinho.model.CarrinhoCompra;
import com.carrinho.model.Item;
import com.carrinho.model.Produto;
import com.carrinho.repository.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {

	@Autowired
	CarrinhoCompraRepository repository;

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 * 
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Item novoItem, String identificacaoCliente) {

		CarrinhoCompra carrinho = repository.findByIdentificacaoCliente(identificacaoCliente);

		Optional<Item> item = carrinho.getItens().stream().filter(i -> i.getProduto().equals(novoItem.getProduto()))
				.findAny();

		if (item.isPresent()) {

			Item itemAtualizado = item.get();

			itemAtualizado.setQuantidade(item.get().getQuantidade() + novoItem.getQuantidade());

			if (itemAtualizado.getValorUnitario().compareTo(novoItem.getValorUnitario()) != 0) {
				itemAtualizado.setValorUnitario(novoItem.getValorUnitario());
			}

			removerItem(itemAtualizado.getProduto(), carrinho);

			carrinho.getItens().add(itemAtualizado);

			repository.save(carrinho);

		} else {

			carrinho.getItens().add(novoItem);

			repository.save(carrinho);

		}

	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no
	 *         carrinho de compras e false caso o produto não exista no carrinho.
	 */
	private boolean removerItem(Produto produto, CarrinhoCompra carrinho) {

		return carrinho.getItens().removeIf(i -> i.getProduto().equals(produto));

	}

	/**
	 * Permite a remoção do item.
	 * 
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no
	 *         carrinho de compras e false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Item itemARemover, String identificacaoCliente) {

		CarrinhoCompra carrinho = repository.findByIdentificacaoCliente(identificacaoCliente);

		boolean itemExcluido = carrinho.getItens()
				.removeIf(i -> i.getProduto()
						.equals(itemARemover.getProduto()));

		if (itemExcluido) {
			repository.save(carrinho);
		}

		return itemExcluido;
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores
	 * totais de todos os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal(String identificacaoCliente) {
		CarrinhoCompra carrinho = repository.findByIdentificacaoCliente(identificacaoCliente);
		return carrinho.getItens()
				.stream().
				map(Item::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens(String identificacaoCliente) {
		CarrinhoCompra carrinho = repository.findByIdentificacaoCliente(identificacaoCliente);
		return carrinho.getItens();
	}

	public Optional<CarrinhoCompra> selecionarCarrinho(String identificacaoCliente) {
		return Optional.ofNullable(repository.findByIdentificacaoCliente(identificacaoCliente));
	}
	
}