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

import com.example.demo.entities.Doencas;
import com.example.demo.services.DoencasService;

@RestController
@RequestMapping("/doencas")
public class DoencasController {

	@Autowired
	DoencasService service;
	
	@GetMapping
	public List<Doencas> buscaTodas(){
		return service.buscaTodas();
	}
	
	@GetMapping("/{id}")
	public Doencas buscaDoencas(@PathVariable Long id) {
		return service.buscaDoencas(id);
	}
	
	@PostMapping
	public Doencas cadastraDoencas(@Valid @RequestBody Doencas doenca) {
		return service.cadastra(doenca);
	}
	
	@PutMapping("/{id}")
	public Doencas atualizaDoencas(@RequestBody Doencas doenca, @PathVariable Long id) {
		return service.atualiza(doenca, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaDoencas(@PathVariable Long id){
		service.delete(id);
	}
}
