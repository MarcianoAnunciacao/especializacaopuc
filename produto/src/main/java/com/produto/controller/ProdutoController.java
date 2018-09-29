package com.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.model.Categoria;
import com.produto.model.Produto;
import com.produto.repository.ProdutoRepository;

@RestController("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	
	
	@GetMapping
	public List<Produto> listar(String categoriaNome, String nome) {
		
		if(nome != null && !nome.isEmpty()) {
			return repository.findByNome(nome);
		}else if(categoriaNome != null && !categoriaNome.isEmpty()) {
			Categoria categoria = new Categoria();
			categoria.setNome(categoriaNome);
			return repository.findByCategoria(categoria);
		}else {
			return repository.findAll();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		
	}
	
}
