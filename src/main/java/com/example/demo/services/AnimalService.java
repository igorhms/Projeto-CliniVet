package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Animal;
import com.example.demo.repositories.AnimalRepository;
import com.example.demo.services.exception.DataIntegrityViolationException;
import com.example.demo.services.exception.EmptyResultDataAccessException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository repository;

	public List<Animal> buscaTodos() {
		return repository.findAll();
	}

	public Animal buscaAnimal(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
	}

	public Animal cadastra(Animal animal) {
		return repository.save(animal);
	}

	public Animal atualiza(Animal animal, Long id) {
		repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Id " + id + " não encontrado"));
		animal.setId(id);
		return repository.save(animal);
	}

	public void deleta(Long id) {
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Id " + id + " não encontrado");
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Integrity violation");
		}
	}
}
