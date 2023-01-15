package com.allasassis.attornatus.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.allasassis.attornatus.entities.Endereco;
import com.allasassis.attornatus.entities.Pessoa;
import com.allasassis.attornatus.repositories.EnderecoRepository;
import com.allasassis.attornatus.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Endereco e1 = new Endereco(null, "Rua Luiz", "84921-993", 23, "São Luiz");
		Endereco e2 = new Endereco(null, "Rua Jorge", "32132-213", 53, "São Paulo");
		Endereco e3 = new Endereco(null, "Rua Paulo", "82372-902", 21, "Rio de Janeiro");
		Endereco e4 = new Endereco(null, "Rua Carlos", "76263-737", 7, "Campinas");
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
		
		Pessoa p1 = new Pessoa(null, "Allas", new Date(), e1);
		Pessoa p2 = new Pessoa(null, "Lucas", new Date(), e2);
		Pessoa p3 = new Pessoa(null, "Aline", new Date(), e3);
		Pessoa p4 = new Pessoa(null, "Sabrina", new Date(), e4);
		pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
	}

}
