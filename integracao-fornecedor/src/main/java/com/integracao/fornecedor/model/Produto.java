package com.integracao.fornecedor.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Produto.class)
public class Produto {
	
	public Produto() {}
	
	private String id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal valor;

	private Integer quantidade;
	
	private String status;
	
	private Categoria categoria;
	
	private Fornecedor fornecedor;
	
	private Boolean ativo;
	
	private List<String> imagens;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", quantidade=" + quantidade + ", status=" + status + ", categoria=" + categoria + ", fornecedor="
				+ fornecedor + ", ativo=" + ativo + ", imagens=" + imagens + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}