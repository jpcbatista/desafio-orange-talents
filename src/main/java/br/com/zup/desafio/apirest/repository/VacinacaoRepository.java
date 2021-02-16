package br.com.zup.desafio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.desafio.apirest.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long>{
	
}
