package com.devcarvalho.midiasDMA.resouces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcarvalho.midiasDMA.entities.Desenvolvedor;
import com.devcarvalho.midiasDMA.services.DesenvolvedorService;

@RestController
@RequestMapping(value = "/desenvolvedores")
public class DesenvolvedorResouce {

	@Autowired
	private DesenvolvedorService service;

	@GetMapping
	public ResponseEntity<List<Desenvolvedor>> findAll() {
		List<Desenvolvedor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Desenvolvedor> findById(@PathVariable Long id) {
		Desenvolvedor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Desenvolvedor> insert(@RequestBody Desenvolvedor obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Desenvolvedor> update(@PathVariable Long id, @RequestBody Desenvolvedor obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
