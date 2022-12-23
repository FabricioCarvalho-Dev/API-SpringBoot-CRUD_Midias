package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Jogo;
import com.devcarvalho.midiasDMA.repositories.JogoRepository;
import com.devcarvalho.midiasDMA.resouces.exceptions.DatabaseException;
import com.devcarvalho.midiasDMA.resouces.exceptions.ResourceNotFoundException;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	public List<Jogo> findAll() {
		return repository.findAll();

	}

	public Jogo findById(Long id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Jogo insert(Jogo obj) {
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

	public Jogo update(Long id, Jogo obj) {
		Jogo entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Jogo entity, Jogo obj) {
		entity.setNome(obj.getNome());
		entity.setAlugado(obj.getAlugado());
		entity.setDigital(obj.getDigital());
		entity.setPreco(obj.getPreco());
	}

}
