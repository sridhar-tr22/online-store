package com.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	List<Product> findByCategoryType(String categoryType);

	Product findByProductId(int productId);

	List<Product> findAllByCategoryType(String categoryType);
	
}
