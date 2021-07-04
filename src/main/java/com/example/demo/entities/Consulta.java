package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Consulta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo data é obrigatório")
	private String data;
	
	@NotBlank(message = "O campo observacoes é obrigatório")
	private String observacoes;
	
	@NotBlank(message = "O campo queixa é obrigatório")
	private String queixa;
	
	@NotBlank(message = "O campo historico é obrigatório")
	private String historico;
	
	@ManyToOne
	@JsonBackReference
	private Animal animalConsulta;
	
	@OneToOne
	private Anamnese anamnese;

	public Consulta(Long id, @NotBlank(message = "O campo data é obrigatório") String data,
			@NotBlank(message = "O campo observacoes é obrigatório") String observacoes,
			@NotBlank(message = "O campo queixa é obrigatório") String queixa,
			@NotBlank(message = "O campo historico é obrigatório") String historico, Animal animalConsulta,
			Anamnese anamnese) {
		super();
		this.id = id;
		this.data = data;
		this.observacoes = observacoes;
		this.queixa = queixa;
		this.historico = historico;
		this.animalConsulta = animalConsulta;
		this.anamnese = anamnese;
	}

	public Consulta() {
		super();
	}
	
	
}
