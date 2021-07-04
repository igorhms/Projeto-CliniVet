package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Exame implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "o campo hemograma não pode ser vazio")
	private Boolean hemograma;
	
	@NotNull(message = "o campo colesterol não pode ser vazio")
	private Boolean colesterol;
	
	@NotNull(message = "o campo fosforo não pode ser vazio")
	private Boolean fosforo;
	
	@NotNull(message = "o campo calcio não pode ser vazio")
	private Boolean calcio;
	
	@NotNull(message = "o campo glicose não pode ser vazio")
	private Boolean glicose;
	
	@NotNull(message = "o campo magnesio não pode ser vazio")
	private Boolean magnesio;
	
	@NotNull(message = "o campo ureia não pode ser vazio")
	private Boolean ureia;
	
	@NotNull(message = "o campo potassio não pode ser vazio")
	private Boolean potassio;

	@NotEmpty(message = "o campo ultrassonografia não pode ser vazio")
	private String ultrassonografia;
	
	@NotEmpty(message = "o campo radiografia não pode ser vazio")
	private String radiografia;
	
	@NotEmpty(message = "o campo hemograma não pode ser vazio")
	private String data;
	
	@ManyToOne
	@JsonBackReference
	private Animal animalExame;

	public Exame(Long id, @NotNull(message = "o campo hemograma não pode ser vazio") Boolean hemograma,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean colesterol,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean fosforo,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean calcio,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean glicose,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean magnesio,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean ureia,
			@NotNull(message = "o campo hemograma não pode ser vazio") Boolean potassio,
			@NotEmpty(message = "o campo hemograma não pode ser vazio") String ultrassonografia,
			@NotEmpty(message = "o campo hemograma não pode ser vazio") String radiografia,
			@NotEmpty(message = "o campo hemograma não pode ser vazio") String data, Animal animalExame) {
		super();
		this.id = id;
		this.hemograma = hemograma;
		this.colesterol = colesterol;
		this.fosforo = fosforo;
		this.calcio = calcio;
		this.glicose = glicose;
		this.magnesio = magnesio;
		this.ureia = ureia;
		this.potassio = potassio;
		this.ultrassonografia = ultrassonografia;
		this.radiografia = radiografia;
		this.data = data;
		this.animalExame = animalExame;
	}

	public Exame() {
		super();
	}
	
	
}
