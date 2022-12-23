package com.devcarvalho.midiasDMA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarvalho.midiasDMA.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

