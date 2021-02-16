package br.com.zup.desafio.apirest.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.desafio.apirest.dto.PacienteDto;
import br.com.zup.desafio.apirest.dto.form.PacienteForm;
import br.com.zup.desafio.apirest.model.Paciente;
import br.com.zup.desafio.apirest.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Transactional
	public ResponseEntity<PacienteDto> cadastrar(PacienteForm form, UriComponentsBuilder uriBuilder){
		
		if(pacienteRepository.existsByEmail(form.getEmail())) {
			throw new IllegalArgumentException("{erro: email já cadastrado}");
		}else if(pacienteRepository.existsByCpf(form.getCpf())) {
			throw new IllegalArgumentException("{erro: cpf já cadastrado}");
		}
		
		Paciente paciente = form.toPaciente();
		pacienteRepository.save(paciente);
		
		URI uri = uriBuilder
				.path("/paciente/{id}")
				.buildAndExpand(paciente
				.getId()).toUri();
		return ResponseEntity.created(uri).body(new PacienteDto(paciente));
	}

}