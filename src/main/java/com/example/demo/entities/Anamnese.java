package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Anamnese implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo problema sistema digestivo é obrigatório")
	private String problemaSistemaDigestivo;
	
	@NotBlank(message = "O campo problema sistema urogenital é obrigatório")
	private String problemaSistemaUroGenital;
	
	@NotBlank(message = "O campo problema sistema cardiorrespiratório é obrigatório")
	private String problemaSistemaCardioRespiratorio;
	
	@NotBlank(message = "O campo problema sistema neurológico é obrigatório")
	private String problemaSistemaNeurologico;
	
	@NotBlank(message = "O campo problema sistema locomotor é obrigatório")
	private String problemaSistemaLocomotor;
	
	@NotBlank(message = "O campo problema pele é obrigatório")
	private String problemaPele;
	
	@NotBlank(message = "O campo problema olhos é obrigatório")
	private String problemaOlhos;
	
	@NotBlank(message = "O campo problema ouvido é obrigatório")
	private String problemaOuvido;
	
	@ManyToMany
	private List<Doencas> doencas;

	public Anamnese(Long id,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaDigestivo,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaUroGenital,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaCardioRespiratorio,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaNeurologico,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaLocomotor,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaPele,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaOlhos,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaOuvido,
			List<Doencas> doencas) {
		super();
		this.id = id;
		this.problemaSistemaDigestivo = problemaSistemaDigestivo;
		this.problemaSistemaUroGenital = problemaSistemaUroGenital;
		this.problemaSistemaCardioRespiratorio = problemaSistemaCardioRespiratorio;
		this.problemaSistemaNeurologico = problemaSistemaNeurologico;
		this.problemaSistemaLocomotor = problemaSistemaLocomotor;
		this.problemaPele = problemaPele;
		this.problemaOlhos = problemaOlhos;
		this.problemaOuvido = problemaOuvido;
		this.doencas = doencas;
	}

	public Anamnese() {
		super();
	}
	
	
}
