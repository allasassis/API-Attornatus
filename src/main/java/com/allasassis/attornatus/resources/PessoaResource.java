package com.allasassis.attornatus.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allasassis.attornatus.entities.Pessoa;
import com.allasassis.attornatus.services.PessoaServices;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaServices service;
	
	/* Listar todas as pessoas */
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/* Listar uma pessoa */
	@GetMapping(value = "/{id}")
	public Pessoa findById(@PathVariable Long id) {
		Pessoa p = service.findById(id);
		return p;
	}
	
	/* Inserir uma pessoa */
	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa p) {
		p = service.insert(p);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(p);
	}
	
	/* Atualizar uma pessoa */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa p) {
		service.update(id, p);
		return ResponseEntity.ok().body(p);
	}
}
