package com.devcarvalho.midiasDMA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarvalho.midiasDMA.entities.Category_midia;

import com.devcarvalho.midiasDMA.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category_midia> findAll() {
		return repository.findAll();

	}

	public Category_midia findById(Long id) {
		Optional<Category_midia> obj = repository.findById(id);
		return obj.get();
	}

}
