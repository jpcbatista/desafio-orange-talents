package br.com.zup.desafio.apirest.dto.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.zup.desafio.apirest.model.Vacinacao;

public class VacinacaoForm {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotBlank(message="{nomeVacina.not.blank}") @Length(min = 2, max = 255, message="{nomeVacina.length}")
	private String nomeVacina;
	
	@NotNull(message="{pacienteId.not.null}")
	private Long pacienteId;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message="{dataVacinacao.pattern}")
	private String dataVacinacao;

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Vacinacao toVacinacao() {
		Vacinacao vacinacao = new Vacinacao();
		vacinacao.setNomeVacina(this.nomeVacina);
		vacinacao.setPacienteId(this.pacienteId);
		vacinacao.setDataVacinacao(LocalDate.parse(this.dataVacinacao, formatter));
		return vacinacao;
		
	}
	
}
