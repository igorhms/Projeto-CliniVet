package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Anamnese;
import com.example.demo.repositories.AnamneseRepository;
import com.example.demo.services.exception.DataIntegrityViolationException;
import com.example.demo.services.exception.EmptyResultDataAccessException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class AnamneseService {
	@Autowired
	AnamneseRepository repository;
	
	public List<Anamnese> buscaTodas() {
		return repository.findAll();
	}
	
	public Anamnese buscaAnamnese(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
	}
		
	public Anamnese cadastra(Anamnese anamnese) {
		return repository.save(anamnese);
	}
	
	public Anamnese atualiza(Anamnese anamnese, Long id) {
		repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Id " + id + " não encontrado"));
		anamnese.setId(id);
		return repository.save(anamnese);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Id " + id + " não encontrado");
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Integrity violation");
		}
	}
	
}
