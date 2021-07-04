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

import com.example.demo.entities.Anamnese;
import com.example.demo.services.AnamneseService;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {

	@Autowired
	AnamneseService service;
	
	@GetMapping
	public List<Anamnese> buscaTodas(){
		return service.buscaTodas();
	}
	
	@GetMapping("/{id}")
	public Anamnese buscaAnamnese(@PathVariable Long id) {
		return service.buscaAnamnese(id);
	}
	
	@PostMapping
	public Anamnese cadastraAnamnese(@Valid @RequestBody Anamnese anamnese) {
		return service.cadastra(anamnese);
	}
	
	@PutMapping("/{id}")
	public Anamnese atualizaAnamnese(@RequestBody Anamnese anamnese, @PathVariable Long id) {
		return service.atualiza(anamnese, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaAnamnese(@PathVariable Long id){
		service.delete(id);
	}
}
