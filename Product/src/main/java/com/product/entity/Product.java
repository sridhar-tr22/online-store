package com.product.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long productId;
		private String productName;
		private BigDecimal productPrice;
		private String productDescription;
		private String productBrand;
		private String categoryType;
		private String categoryTypeSubtype;
		private int productRating;
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public BigDecimal getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(BigDecimal productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public String getProductBrand() {
			return productBrand;
		}
		public void setProductBrand(String productBrand) {
			this.productBrand = productBrand;
		}
		public String getCategoryType() {
			return categoryType;
		}
		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}
		public String getCategoryTypeSubtype() {
			return categoryTypeSubtype;
		}
		public void setCategoryTypeSubtype(String categoryTypeSubtype) {
			this.categoryTypeSubtype = categoryTypeSubtype;
		}
		public int getProductRating() {
			return productRating;
		}
		public void setProductRating(int productRating) {
			this.productRating = productRating;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	
	
}
