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

import com.example.demo.entities.Exame;
import com.example.demo.services.ExameService;

@RestController
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	ExameService service;
	
	@GetMapping
	public List<Exame> buscaTodas(){
		return service.buscaTodas();
	}
	
	@GetMapping("/{id}")
	public Exame buscaExame(@PathVariable Long id) {
		return service.buscaExame(id);
	}
	
	@PostMapping
	public Exame cadastraExame(@Valid @RequestBody Exame exame) {
		return service.cadastra(exame);
	}
	
	@PutMapping("/{id}")
	public Exame atualizaExame(@RequestBody Exame exame, @PathVariable Long id) {
		return service.atualiza(exame, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaExame(@PathVariable Long id){
		service.deleta(id);
	}
}
