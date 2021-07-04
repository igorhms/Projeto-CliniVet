package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Animal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo foto é obrigatório")
	private String foto;
	
	@NotBlank(message = "O campo raca é obrigatório")
	private String raca;
	
	@NotBlank(message = "O campo pelagem é obrigatório")
	private String pelagem;
	
	@NotNull(message = "o campo peso não pode ser nulo")
	@Min(value= (long) 0.0, message = "O campo peso deve ser maior ou igual a 0.1")
	private Double peso;
	
	@NotNull(message = "o campo tipo não pode ser nulo")
	@Min(value=1,message = "O campo tipo deve ser preenchido com o valor 1 para cães ou 2 para gatos")
	@Max(value=2,message = "O campo tipo deve ser preenchido com o valor 1 para cães ou 2 para gatos")
	private Integer tipo;
	
	@NotBlank(message = "O campo data de nascimento é obrigatório")
	private String dataNascimento;
	
	@NotBlank(message = "O campo dataCadastro é obrigatório")
	private String dataCadastro;
	
	@NotNull(message = "o campo estado não pode ser nulo")
	@Min(value=0,message = "O campo estado deve ser preenchido com o valor 1 cadastros ativos ou 0 para inativos")
	@Max(value=1,message = "O campo estado deve ser preenchido com o valor 1 cadastros ativos ou 0 para inativos")
	private Integer estado;
	
	@OneToMany(mappedBy = "animalConsulta")
	@JsonManagedReference
	private List<Consulta> consultas = new ArrayList<Consulta>(); 
	
	@OneToMany(mappedBy = "animalExame")
	private List<Exame> exames = new ArrayList<Exame>();

	public Animal(Long id, @NotBlank(message = "O campo nome é obrigatório") String nome,
			@NotBlank(message = "O campo foto é obrigatório") String foto,
			@NotBlank(message = "O campo raca é obrigatório") String raca,
			@NotBlank(message = "O campo pelagem é obrigatório") String pelagem,
			@NotNull(message = "o campo peso não pode ser nulo") @Min(value = 0, message = "O campo peso deve ser maior ou igual a 1") Double peso,
			@NotNull(message = "o campo tipo não pode ser nulo") @Min(value = 1, message = "O campo tipo deve ser preenchido com o valor 1 para cães ou 2 para gatos") @Max(value = 2, message = "O campo tipo deve ser preenchido com o valor 1 para cães ou 2 para gatos") Integer tipo,
			@NotBlank(message = "O campo data de nascimento é obrigatório") String dataNascimento,
			@NotBlank(message = "O campo dataCadastro é obrigatório") String dataCadastro,
			@NotNull(message = "o campo estado não pode ser nulo") @Min(value = 0, message = "O campo estado deve ser preenchido com o valor 1 cadastros ativos ou 0 para inativos") @Max(value = 1, message = "O campo estado deve ser preenchido com o valor 1 cadastros ativos ou 0 para inativos") Integer estado,
			List<Consulta> consultas, List<Exame> exames) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.raca = raca;
		this.pelagem = pelagem;
		this.peso = peso;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.estado = estado;
		this.consultas = consultas;
		this.exames = exames;
	}

	public Animal() {
		super();
	}
	
}
