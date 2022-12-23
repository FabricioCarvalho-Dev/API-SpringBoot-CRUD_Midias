package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Desenvolvedor;
import com.devcarvalho.midiasDMA.repositories.DesenvolvedorRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DesenvolvedorService {

	@Autowired
	private DesenvolvedorRepository repository;

	public List<Desenvolvedor> findAll() {
		return repository.findAll();

	}

	public Desenvolvedor findById(Long id) {
		Optional<Desenvolvedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Desenvolvedor insert(Desenvolvedor obj) {
		return repository.save(obj);
	}

	public Desenvolvedor update(Long id, Desenvolvedor obj) {
		try {
			Desenvolvedor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Desenvolvedor entity, Desenvolvedor obj) {
		entity.setNome(obj.getNome());
	}

}
