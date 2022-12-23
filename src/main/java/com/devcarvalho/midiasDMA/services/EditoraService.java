package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Editora;
import com.devcarvalho.midiasDMA.repositories.EditoraRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;

	public List<Editora> findAll() {
		return repository.findAll();

	}

	public Editora findById(Long id) {
		Optional<Editora> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Editora insert(Editora obj) {
		return repository.save(obj);
	}

	public Editora update(Long id, Editora obj) {
		try {
			Editora entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Editora entity, Editora obj) {
		entity.setNome(obj.getNome());
	}

}
