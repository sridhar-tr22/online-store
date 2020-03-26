package com.training.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.startsWith;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.training.dto.OrderRequest;
import com.training.services.OrderServiceImpl;

@WebMvcTest
class UserControllerTest {

	static final String BASE_URL = "/online-store";

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderServiceImpl orderServiceImpl;
	private ObjectMapper mapper;
	private ObjectWriter writer;
	OrderRequest request;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		mapper = new ObjectMapper();
		writer = mapper.writer().with(SerializationFeature.WRAP_ROOT_VALUE).withDefaultPrettyPrinter();
		OrderRequest request = new OrderRequest();
		request.setUserId("user123");
		request.setProductId("prd123");
		request.setProductName("prd_Name");
		request.setProductPrice(new BigDecimal(1000.00));
		request.setProductQuantity(1);
		request.setSellerId("seller123");
		request.setTotalAmount(new BigDecimal(1000.00));

	}

	@Test
	void testPlaceOrder() throws Exception {
		OrderRequest any = Mockito.any(OrderRequest.class);
		Mockito.when(orderServiceImpl.placeOrder(any)).thenReturn(null);

		String writeValueAsString = writer.writeValueAsString(request);

		String writeValueAsJson = "{\"userId\":\"user123\",\"productId\":\"prd123\",\"productName\":\"Samsung S8\","
				+ "\"productQuantity\":1,\"productPrice\":10000.00,\"totalAmount\":10000.00,\"sellerId\":\"seller123\"}";

		mockMvc.perform(
				post(BASE_URL + "/users/orders").contentType(MediaType.APPLICATION_JSON).content(writeValueAsJson))
				.andExpect(jsonPath("$.message.statusCode", is("201")))
				.andExpect(
						jsonPath("$.message.statusCode", hasItems(startsWith("Your order is palced successfuly for"))))
				.andExpect(status().isOk());

	}

	@Test
	void testGetOrderSample() throws Exception {
		mockMvc.perform(get(BASE_URL + "/users/orders/samples")).andDo(print());
	}

}
