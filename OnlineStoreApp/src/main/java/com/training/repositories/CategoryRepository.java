package com.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

	List<Category> findByCategoryType(String categoryType);
}
