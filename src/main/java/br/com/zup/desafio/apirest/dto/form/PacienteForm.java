package br.com.zup.desafio.apirest.dto.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zup.desafio.apirest.model.Paciente;

public class PacienteForm {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotBlank(message="{nome.not.blank}") @Length(min = 2, max = 255, message="{nome.length}")
	private String nome;
	
	@Email(message="{email.email}")
	private String email;
	
	@CPF(message="{cpf.cpf}")
	private String cpf;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message="{dataNascimento.pattern}")
	private String dataNascimento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Paciente toPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome(this.nome);
		paciente.setEmail(this.email);
		paciente.setCpf(this.cpf);
		paciente.setDataNascimento(LocalDate.parse(this.dataNascimento, formatter));
		return paciente;
	}
}
