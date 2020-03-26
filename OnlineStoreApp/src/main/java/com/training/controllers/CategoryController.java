package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.CategoryDetailsDto;
import com.training.services.CategoryService;


@RestController
@RequestMapping("/products")
public class CategoryController {
	
		@Autowired
		CategoryService categoryService;
		
		/**
		 * This method is used to find that what are the available categories in it.
		 * @author Latha V
		 * @return
		 */
		
		
		@GetMapping("/categories")
		public ResponseEntity<List<CategoryDetailsDto>> categories(){
			
			List<CategoryDetailsDto> categoryDetailsDtos = categoryService.categories();
			return new ResponseEntity<>(categoryDetailsDtos,HttpStatus.OK);
		}
	}

