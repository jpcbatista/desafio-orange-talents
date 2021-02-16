package br.com.zup.desafio.apirest.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.desafio.apirest.dto.VacinacaoDto;
import br.com.zup.desafio.apirest.dto.form.VacinacaoForm;
import br.com.zup.desafio.apirest.model.Vacinacao;
import br.com.zup.desafio.apirest.repository.PacienteRepository;
import br.com.zup.desafio.apirest.repository.VacinacaoRepository;

@Service
public class VacinacaoService {

	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Transactional
	public ResponseEntity<VacinacaoDto> cadastrar(VacinacaoForm form, UriComponentsBuilder uriBuilder){
		
		if(!pacienteRepository.existsById(form.getPacienteId())) {
			throw new IllegalArgumentException("{erro: paciente não existe}");
		}
		
		Vacinacao vacinacao = form.toVacinacao();
		vacinacaoRepository.save(vacinacao);
		
		URI uri = uriBuilder.path("/vacinacao/{id}").buildAndExpand(vacinacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new VacinacaoDto(vacinacao));
	}
	
}
