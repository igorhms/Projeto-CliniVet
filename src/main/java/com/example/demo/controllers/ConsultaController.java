package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Consulta;
import com.example.demo.services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	ConsultaService service;
	
	@GetMapping
	public List<Consulta> buscaTodas(){
		return service.buscaTodas();
	}
	
	@GetMapping("/{id}")
	public Consulta buscaConsulta(@PathVariable Long id) {
		return service.buscaConsulta(id);
	}
	
	@PostMapping
	public Consulta cadastraConsulta(@Valid @RequestBody Consulta consulta) {
		return service.cadastra(consulta);
	}
	
	@PostMapping("/anamese/{id}")
	public Consulta cadastraConsultaComAnamnese(@RequestBody Consulta consulta, @PathVariable Long id) {
		return service.cadastraConsultaComAnamnese(consulta, id);
	}
	
	@PutMapping("/{id}")
	public Consulta atualizaConsulta(@RequestBody Consulta consulta, @PathVariable Long id) {
		return service.atualiza(consulta, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaConsulta(@PathVariable Long id){
		service.delete(id);
	}
}
