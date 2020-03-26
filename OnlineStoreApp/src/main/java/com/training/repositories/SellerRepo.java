package com.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entities.Seller;


@Repository
public interface SellerRepo extends JpaRepository<Seller, Long>{

}
