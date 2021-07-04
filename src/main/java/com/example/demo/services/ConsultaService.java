package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Anamnese;
import com.example.demo.entities.Consulta;
import com.example.demo.repositories.AnamneseRepository;
import com.example.demo.repositories.ConsultaRepository;
import com.example.demo.services.exception.DataIntegrityViolationException;
import com.example.demo.services.exception.EmptyResultDataAccessException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository repository;
	@Autowired
	AnamneseRepository anamneseRepository;
	
	public List<Consulta> buscaTodas() {
		return repository.findAll();
	}
	
	public Consulta buscaConsulta(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
	}
	
	public Consulta cadastra(Consulta consulta) {
		return repository.save(consulta);
	}
	
	public Consulta cadastraConsultaComAnamnese(Consulta consulta, Long id) {
		Anamnese anamnese = anamneseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada. (id: " + id + ")"));
		consulta.setAnamnese(anamnese);
		return repository.save(consulta);
	}
	
	public Consulta atualiza(Consulta consulta, Long id) {
		repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Id " + id + " não encontrado"));
		consulta.setId(id);
		return repository.save(consulta);
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
