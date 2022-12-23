package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Revista;
import com.devcarvalho.midiasDMA.repositories.RevistaRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.DatabaseException;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RevistaService {
	
	@Autowired
	private RevistaRepository repository;
	
	public List<Revista> findAll() {
		return repository.findAll();
		
	}
	
	public Revista findById(Long id) {
		Optional<Revista> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Revista insert(Revista obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
               throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Revista update(Long id, Revista obj) {
		try {
			Revista entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			 throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Revista entity, Revista obj) {
		entity.setNome(obj.getNome());
		entity.setAlugado(obj.getAlugado());
		entity.setPreco(obj.getPreco());
	}
	

}
