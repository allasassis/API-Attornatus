package com.allasassis.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.allasassis.attornatus.entities.Endereco;
import com.allasassis.attornatus.entities.Pessoa;
import com.allasassis.attornatus.repositories.EnderecoRepository;
import com.allasassis.attornatus.repositories.PessoaRepository;
import com.allasassis.attornatus.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class EnderecoServices {

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private PessoaRepository pRepository;
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		try {
			Optional<Pessoa> obj = pRepository.findById(id);
			Endereco e = obj.get().getEndereco();
			return e;
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Endereco update(Long id, Endereco e) {
		try {
			Endereco entity = repository.getReferenceById(id);
			updateData(entity, e);
			return repository.save(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Endereco entity, Endereco e) {
		entity.setLogradouro(e.getLogradouro());
		entity.setCep(e.getCep());
		entity.setCidade(e.getCidade());
		entity.setNumero(e.getNumero());
	}
}
