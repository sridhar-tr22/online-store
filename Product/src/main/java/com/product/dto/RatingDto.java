package com.product.dto;

public class RatingDto {
	
	
	private Long userId;
	private Long productId;
	private String userRating;
	private String userFeedback;
	private int sellerRating;
	private String sellerFeedback;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	public String getUserFeedback() {
		return userFeedback;
	}
	public void setUserFeedback(String userFeedback) {
		this.userFeedback = userFeedback;
	}
	public int getSellerRating() {
		return sellerRating;
	}
	public void setSellerRating(int sellerRating) {
		this.sellerRating = sellerRating;
	}
	public String getSellerFeedback() {
		return sellerFeedback;
	}
	public void setSellerFeedback(String sellerFeedback) {
		this.sellerFeedback = sellerFeedback;
	}
	
		
	
	

}
