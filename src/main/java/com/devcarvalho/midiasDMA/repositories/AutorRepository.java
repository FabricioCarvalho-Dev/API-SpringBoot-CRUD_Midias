package com.devcarvalho.midiasDMA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarvalho.midiasDMA.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}

