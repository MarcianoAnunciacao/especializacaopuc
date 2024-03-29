package com.pagamento.model;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class ProdutoConverter {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public ProdutoConverter(Long codigo, String descricao) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
    	return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
    	return descricao;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		ProdutoConverter produto = (ProdutoConverter) obj;
		if(produto == null) {
			return false;
		}
		if (codigo == null) {
			if (produto.getCodigo() != null)
				return false;
		} else if (!codigo.equals(produto.getCodigo()))
			return false;
		return true;
	}
}