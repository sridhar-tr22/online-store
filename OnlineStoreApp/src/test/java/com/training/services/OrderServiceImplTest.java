package com.training.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.training.dto.OrderRequest;
import com.training.dto.OrderResponse;
import com.training.entities.Order;
import com.training.repositories.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class OrderServiceImplTest {

	@Autowired
	private OrderServiceImpl serviceImpl;
	
	@MockBean
	private OrderRepository orderRepository;
	
	private OrderRequest orderRequest;
	private Order order;
	
	@BeforeEach
	void setUp() throws Exception {
		order = new Order();
		order.setOrderId("1001");
		order.setProductId("123");
		order.setProductName("Samsung Mobile");
		order.setProductPrice(new BigDecimal("10000.00"));
		order.setProductQuantity(1);
		order.setSellerId("300");
		order.setUserId("User111");
		
		orderRequest = new OrderRequest();
		orderRequest.setProductId("123");
		orderRequest.setProductName("Samsung Mobile");
		orderRequest.setProductPrice(new BigDecimal("10000.00"));
		orderRequest.setProductQuantity(1);
		orderRequest.setSellerId("300");
		orderRequest.setUserId("User111");
	}

	@Test
	void testOrderServiceImpl() {
		Order any = Mockito.any(Order.class);
		Mockito.when(orderRepository.save(any)).thenReturn(order);
		
		OrderResponse placeOrder = serviceImpl.placeOrder(orderRequest);
		log.info(String.format("Order ID: %s", placeOrder.getOrderId()));
		log.info(String.format("Name: %s", placeOrder.getProductName()));
		log.info(String.format("Qty: %d", placeOrder.getProductQuantity()));
		log.info(String.format("Total Amount: %d", placeOrder.getTotalAmount()));
		
		assertThat(placeOrder.getOrderId()).isNotEmpty();
	}

	@Test
	void testPlaceOrder() {
		
	}

}
