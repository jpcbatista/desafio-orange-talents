package br.com.zup.desafio.apirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.desafio.apirest.dto.PacienteDto;
import br.com.zup.desafio.apirest.dto.form.PacienteForm;
import br.com.zup.desafio.apirest.service.PacienteService;


@RestController
@RequestMapping("/novo-paciente")
public class PacienteRestController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping
	public ResponseEntity<PacienteDto> cadastrarPaciente(@RequestBody @Valid PacienteForm form, UriComponentsBuilder uriBuilder) {
		return pacienteService.cadastrar(form, uriBuilder);
	}
	
}
