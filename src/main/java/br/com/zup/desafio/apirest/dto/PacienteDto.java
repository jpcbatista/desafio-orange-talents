package br.com.zup.desafio.apirest.dto;

import java.time.LocalDate;

import br.com.zup.desafio.apirest.model.Paciente;

public class PacienteDto {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;

	public PacienteDto(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.cpf = paciente.getCpf();
		this.dataNascimento = paciente.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

}
