package com.electro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Brand {
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
	@NotNull
	@Pattern(regexp = "^[A-Za-z+]+[0-9+]*$", message = "BrandName should not start with number")
	private String brandName;
	
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
}
