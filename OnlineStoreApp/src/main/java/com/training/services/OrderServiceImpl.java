package com.training.services;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.constants.OrderConstants;
import com.training.dto.OrderRequest;
import com.training.dto.OrderResponse;
import com.training.dto.ResponseMessage;
import com.training.entities.Order;
import com.training.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	private Order order;
	private OrderResponse orderResponse;
	private ResponseMessage responseMessage;
	
	public OrderServiceImpl() {
		order = new Order();
		orderResponse = new OrderResponse();
		responseMessage = new ResponseMessage();
		
	}

	@Override
	public OrderResponse placeOrder(OrderRequest request) {
		order.setOrderId(generateOrderId());
		order.setUserId(request.getUserId());
		order.setProductId(request.getProductId());
		order.setProductName(request.getProductName());
		order.setProductPrice(request.getProductPrice());
		order.setProductQuantity(request.getProductQuantity());
		order.setTotalAmount(calculateTotalCost(request.getProductPrice(), request.getProductQuantity()));
		order.setSellerId(request.getSellerId());
		Order saved = orderRepository.save(order);
		if(Objects.nonNull(saved)) {
			orderResponse.setOrderId(saved.getOrderId());
			orderResponse.setProductName(saved.getProductName());
			orderResponse.setProductQuantity(saved.getProductQuantity());
			orderResponse.setTotalAmount(saved.getTotalAmount());
			responseMessage.setStatusCode(OrderConstants.ORDER_CODE_CREATED);
			responseMessage.setMessage(String.format(OrderConstants.ORDER_PLACED_MESSAGE_SUCCESS, saved.getProductName()));
			orderResponse.setMessage(responseMessage);
		}
		return orderResponse;
	}

	private BigDecimal calculateTotalCost(BigDecimal productPrice, Integer productQuantity) {
		BigDecimal total = BigDecimal.ZERO;
		productPrice = productPrice.multiply(BigDecimal.valueOf(productQuantity));
		total = productPrice;
		return total;
	}
	
	private String generateOrderId() {
		AtomicInteger integer = new AtomicInteger(100);
		int incrementAndGet = integer.incrementAndGet();
		return String.valueOf(incrementAndGet);
	}
}
