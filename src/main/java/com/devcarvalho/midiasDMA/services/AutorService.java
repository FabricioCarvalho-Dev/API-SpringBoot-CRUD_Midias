package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Autor;
import com.devcarvalho.midiasDMA.repositories.AutorRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.DatabaseException;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public List<Autor> findAll() {
		return repository.findAll();

	}

	public Autor findById(Long id) {
		Optional<Autor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Autor insert(Autor obj) {
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

	public Autor update(Long id, Autor obj) {
		try {
			Autor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Autor entity, Autor obj) {
		entity.setNome(obj.getNome());
	}

}
