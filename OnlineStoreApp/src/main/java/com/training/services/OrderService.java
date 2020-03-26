package com.training.services;

import com.training.dto.OrderRequest;
import com.training.dto.OrderResponse;

/**
 * @author User1
 *
 */
public interface OrderService {

	/**
	 * <p>
	 * creates a purchase order record for the user.
	 * </p>
	 * 
	 * @param {@link OrderRequest}
	 * @return {@link OrderResponse }
	 */
	public OrderResponse placeOrder(OrderRequest request);
}
