package com.training.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.training.entities.Product;

@DataJpaTest
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	private Product productData_1;
	private Product productData_2;
	private Product productData_3;
	private Product productData_4;
	private Product productData_5;
	private Product productData_6;
	
	@BeforeEach
	void setUp() throws Exception {
		productData_1 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
		productData_2 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
		productData_3 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
		productData_4 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
		productData_5 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
		productData_6 = new Product("Redmi 8", BigDecimal.valueOf(10000), "This smartphone features a 15.8-cm (6.22) Dot Notch Display, "
				+ "a 12 MP + 2 MP AI Dual Camera, and a 5000 mAh High-capacity Battery to offer detailed views of the stunning photos "
				+ "that you can click all day long without running out of battery life.", "Mi Mobiles",
				"Electronics", "Mobile", 4);
	}

	@Test
	void testSaveAll() {
		
	}

}
