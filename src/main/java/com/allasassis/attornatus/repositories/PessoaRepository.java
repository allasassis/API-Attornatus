package com.allasassis.attornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allasassis.attornatus.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
