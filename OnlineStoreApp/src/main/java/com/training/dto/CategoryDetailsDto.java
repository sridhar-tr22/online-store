package com.training.dto;

import java.io.Serializable;

public class CategoryDetailsDto implements Serializable{

	private static final long serialVersionUID = -6566203865949694322L;
	
	private Integer categoryId;
	private String categoryType;
   @Override
	public String toString() {
		return "CategoryDetailsDto [categoryId=" + categoryId + ", categoryType=" + categoryType + ", categorySubtype="
				+ categorySubtype + "]";
	}
public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getCategorySubtype() {
		return categorySubtype;
	}
	public void setCategorySubtype(String categorySubtype) {
		this.categorySubtype = categorySubtype;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
private String categorySubtype;
}
 


