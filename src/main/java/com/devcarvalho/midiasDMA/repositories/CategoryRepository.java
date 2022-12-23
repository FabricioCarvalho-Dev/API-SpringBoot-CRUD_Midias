package com.devcarvalho.midiasDMA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarvalho.midiasDMA.entities.Category_midia;

public interface CategoryRepository extends JpaRepository<Category_midia, Long> {

}
