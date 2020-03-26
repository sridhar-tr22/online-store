package com.training.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author User1
 *
 *         <p>
 *         this class represents Product entity associated with product table.
 *         </p>
 *
 */
@Entity
public class Product {

	@Id
	private Long productId;
	private String productName;
	private BigDecimal productPrice;
	private String productDescription;
	private String productBrand;
	private String categoryType;
	private String categorySubtype;
	private int productRating;

	/**
	 * <p>
	 * no-argument constructor
	 * </p>
	 */
	public Product() {
	}
	
	

	/**
	 * @param productName
	 * @param productPrice
	 * @param productDescription
	 * @param productBrand
	 * @param categoryType
	 * @param categorySubtype
	 * @param productRating
	 */
	public Product(String productName, BigDecimal productPrice, String productDescription, String productBrand,
			String categoryType, String categorySubtype, int productRating) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productBrand = productBrand;
		this.categoryType = categoryType;
		this.categorySubtype = categorySubtype;
		this.productRating = productRating;
	}



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
		return categorySubtype;
	}

	public void setCategoryTypeSubtype(String categorySubtype) {
		this.categorySubtype = categorySubtype;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

}
