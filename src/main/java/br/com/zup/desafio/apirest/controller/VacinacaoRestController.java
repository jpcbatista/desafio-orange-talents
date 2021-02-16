package br.com.zup.desafio.apirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.desafio.apirest.dto.VacinacaoDto;
import br.com.zup.desafio.apirest.dto.form.VacinacaoForm;
import br.com.zup.desafio.apirest.service.VacinacaoService;


@RestController
@RequestMapping("/nova-vacinacao")
public class VacinacaoRestController {
	
	@Autowired
	private VacinacaoService vacinacaoService;
	
	@PostMapping
	public ResponseEntity<VacinacaoDto> cadastrarPaciente(@RequestBody @Valid VacinacaoForm form, UriComponentsBuilder uriBuilder) {
		return vacinacaoService.cadastrar(form, uriBuilder);
	}
	
}
