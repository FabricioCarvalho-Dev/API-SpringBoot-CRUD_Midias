package com.devcarvalho.midiasDMA.resouces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcarvalho.midiasDMA.entities.Jogo;
import com.devcarvalho.midiasDMA.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResouce {
	
	@Autowired
	private JogoService service;
	
	@GetMapping
	public ResponseEntity<List<Jogo>> findAll() {
		List<Jogo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogo> findById(@PathVariable Long id) {
		Jogo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Jogo> insert(@RequestBody Jogo obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Jogo> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}


}
