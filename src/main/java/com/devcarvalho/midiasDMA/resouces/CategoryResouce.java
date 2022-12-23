package com.devcarvalho.midiasDMA.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarvalho.midiasDMA.entities.Category_midia;
import com.devcarvalho.midiasDMA.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category_midia>> findAll() {
		List<Category_midia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category_midia> findById(@PathVariable Long id) {
		Category_midia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
