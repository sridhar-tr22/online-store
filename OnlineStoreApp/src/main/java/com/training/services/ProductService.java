package com.training.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.ProductDto;
import com.training.entities.Product;
import com.training.exceptions.ProductException;
import com.training.repositories.CategoryRepository;
import com.training.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public List<ProductDto> products(String categoryType) {
		

		List<ProductDto> productList = new ArrayList<>();
		List<Product> products = productRepository.findByCategoryType(categoryType);
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productList.add(productDto);
		}
		return productList;
	}

	public Product productDetails(Integer productId) throws ProductException {
		
		
		Product product = productRepository.findByProductId(productId);
	
		return product;
	}
}


