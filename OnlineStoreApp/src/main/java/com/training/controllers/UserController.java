package com.training.controllers;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.OrderRequest;
import com.training.dto.OrderResponse;
import com.training.services.OrderServiceImpl;

/**
 * @author User1
 *
 */
@RestController
@RequestMapping("/online-store")
public class UserController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(path = "/users/orders")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
		Objects.requireNonNull(request);
		OrderResponse placeOrder = orderServiceImpl.placeOrder(request);
		return new ResponseEntity<OrderResponse>(placeOrder, HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/orders/samples")
	public ResponseEntity<OrderRequest> getOrderSample() {
		OrderRequest request = new OrderRequest();
		request.setUserId("user123");
		request.setProductId("prd123");
		request.setProductName("prd_Name");
		request.setProductPrice(new BigDecimal(1000.00));
		request.setProductQuantity(1);
		request.setSellerId("seller123");
		request.setTotalAmount(new BigDecimal(1000.00));
		return new ResponseEntity<>(request, HttpStatus.OK);
	}
}
