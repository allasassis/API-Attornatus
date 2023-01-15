package com.allasassis.attornatus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allasassis.attornatus.entities.Endereco;
import com.allasassis.attornatus.entities.Pessoa;
import com.allasassis.attornatus.services.EnderecoServices;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	public EnderecoServices service;
	
	/* Listar todos os endereços */
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/* Listar endereços da pessoa */
	@GetMapping(value = "/{id}")
	public Endereco findById(@PathVariable Long id) {
		Endereco e = service.findById(id);
		return e;
	}
	
	/* Alterar o endereço da pessoa */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco e) {
		service.update(id, e);
		return ResponseEntity.ok().body(e);
	}
}
