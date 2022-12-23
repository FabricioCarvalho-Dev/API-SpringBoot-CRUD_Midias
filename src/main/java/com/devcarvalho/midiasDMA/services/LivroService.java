package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.devcarvalho.midiasDMA.entities.Livro;
import com.devcarvalho.midiasDMA.repositories.LivroRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.DatabaseException;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();

	}

	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Livro insert(Livro obj) {
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

	public Livro update(Long id, Livro obj) {
		try {
			Livro entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Livro entity, Livro obj) {
		entity.setNome(obj.getNome());
		entity.setAlugado(obj.getAlugado());
		entity.setEdicao(obj.getEdicao());
		entity.setPreco(obj.getPreco());
	}
}
