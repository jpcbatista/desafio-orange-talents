package br.com.zup.desafio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.desafio.apirest.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	boolean existsByCpf(String cpf);

	boolean existsByEmail(String email);
	
	boolean existsById(Long id);

	
}
