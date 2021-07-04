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

import com.example.demo.entities.Animal;
import com.example.demo.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	AnimalService service;
	
	@GetMapping
	public List<Animal> buscaTodos(){
		return service.buscaTodos();
	}
	
	@GetMapping("{id}")
	public Animal buscaAnimal(@PathVariable Long id) {
		return service.buscaAnimal(id);
	}
	
	@PostMapping
	public Animal cadastraAnimal(@Valid @RequestBody Animal animal) {
		return service.cadastra(animal);
	}
	
	@PutMapping("/{id}")
	public Animal atualizaAnimal(@RequestBody Animal animal, @PathVariable Long id) {
		return service.atualiza(animal, id);
	}
	
	@DeleteMapping("/{id}")
	void deletaAnimal(@PathVariable Long id) {
		service.deleta(id);
	}
	
}
