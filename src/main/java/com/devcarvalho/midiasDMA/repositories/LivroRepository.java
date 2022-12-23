package com.devcarvalho.midiasDMA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarvalho.midiasDMA.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
