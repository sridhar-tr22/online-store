package com.training.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.CategoryDetailsDto;
import com.training.entities.Category;
import com.training.repositories.CategoryRepository;


@Service
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;

	public List<CategoryDetailsDto> categories() {
		
		List<CategoryDetailsDto> categoryDetailsDtos = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();

		for (Category category : categories) {
			CategoryDetailsDto categoryDetailsDto = new CategoryDetailsDto();
			BeanUtils.copyProperties(category, categoryDetailsDto);
			categoryDetailsDtos.add(categoryDetailsDto);
		}

		return categoryDetailsDtos;
	}
}
