package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Exame;
import com.example.demo.repositories.ExameRepository;
import com.example.demo.services.exception.DataIntegrityViolationException;
import com.example.demo.services.exception.EmptyResultDataAccessException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class ExameService {
	@Autowired
	ExameRepository repository;

	public List<Exame> buscaTodas() {
		return repository.findAll();
	}

	public Exame buscaExame(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
	}

	public Exame cadastra(Exame exame) {
		return repository.save(exame);
	}

	public Exame atualiza(Exame exame, Long id) {
		repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Id " + id + " não encontrado"));
		exame.setId(id);
		return repository.save(exame);
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
