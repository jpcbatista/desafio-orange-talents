package br.com.zup.desafio.apirest.dto;

import java.time.LocalDate;

import br.com.zup.desafio.apirest.model.Vacinacao;

public class VacinacaoDto {

	private Long id;
	private String nomeVacina;
	private Long pacienteId;
	private LocalDate dataVacinacao;
	
	public VacinacaoDto(Vacinacao vacinacao) {
		this.id = vacinacao.getId();
		this.nomeVacina = vacinacao.getNomeVacina();
		this.pacienteId = vacinacao.getPacienteId();
		this.dataVacinacao = vacinacao.getDataVacinacao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	
	public Long getPacienteId() {
		return pacienteId;
	}
	
	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}
	
}
