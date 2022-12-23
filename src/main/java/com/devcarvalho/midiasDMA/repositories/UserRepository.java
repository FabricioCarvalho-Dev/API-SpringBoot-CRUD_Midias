package com.devcarvalho.midiasDMA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarvalho.midiasDMA.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
