package com.allasassis.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.allasassis.attornatus.entities.Pessoa;
import com.allasassis.attornatus.repositories.PessoaRepository;
import com.allasassis.attornatus.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class PessoaServices {

	@Autowired
	public PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pessoa insert(Pessoa p) {
		return repository.save(p);
	}
	
	public Pessoa update(Long id, Pessoa p) {
		try {
			Pessoa entity = repository.getReferenceById(id);
			updateData(entity, p);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Pessoa entity, Pessoa p) {
		entity.setNome(p.getNome());
		entity.setDate(p.getDate());
		entity.setEndereco(p.getEndereco());
	}
}
