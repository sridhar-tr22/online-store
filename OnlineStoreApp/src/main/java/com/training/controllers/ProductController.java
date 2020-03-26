package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.ProductDto;
import com.training.entities.Product;
import com.training.exceptions.ProductException;
import com.training.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * This method is used to based on categoryId we have to know the what are the
	 * available categories in it.
	 * 
	 * @author Latha V
	 * @param categoryId
	 * @return
	 */

	@GetMapping("/products/{categoryType}")
	public ResponseEntity<List<ProductDto>> products(@PathVariable("categoryType") String categoryType) {

		return new ResponseEntity<>(productService.products(categoryType), HttpStatus.OK);
	}

	/**
	 * In this API we are going to get the details about that particular product
	 * based on productId.
	 * 
	 * @author Latha V
	 * @param productId
	 * @return
	 * @throws ProductException
	 */
	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> productDetails(@PathVariable("productId") Integer productId)
			throws ProductException {

		return new ResponseEntity<>(productService.productDetails(productId), HttpStatus.OK);
	}
}
