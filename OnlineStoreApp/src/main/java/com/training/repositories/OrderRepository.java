package com.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String>{}
