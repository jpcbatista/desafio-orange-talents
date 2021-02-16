package br.com.zup.desafio.apirest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeVacina;
	
	@ManyToOne
	@JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID")
	private Paciente paciente = new Paciente();
	
	private LocalDate dataVacinacao;

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getPacienteId() {
		return paciente.getId();
	}

	public void setPacienteId(Long pacienteId) {
		this.paciente.setId(pacienteId);
	}
	
}
