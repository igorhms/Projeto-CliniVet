package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doencas;
import com.example.demo.repositories.DoencasRepository;
import com.example.demo.services.exception.DataIntegrityViolationException;
import com.example.demo.services.exception.EmptyResultDataAccessException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class DoencasService {
	@Autowired
	DoencasRepository repository;
	
	public List<Doencas> buscaTodas() {
		return repository.findAll();
	}
	
	public Doencas buscaDoencas(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
	}
	
	public Doencas cadastra(Doencas doencas) {
		return repository.save(doencas);
	}
	
	public Doencas atualiza(Doencas doencas, Long id) {
		repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Id " + id + " não encontrado"));
		doencas.setId(id);
		return repository.save(doencas);
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
