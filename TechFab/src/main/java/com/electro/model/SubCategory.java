package com.electro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SubCategory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCategoryId;
	private int categoryId;
	@NotNull
	@Pattern(regexp = "^[A-Za-z+]+[0-9+]*$", message = "*Name should not start with number")
	private String subCategoryName;
	@NotEmpty(message="*Field can not be empty")
	private String subCategoryDescription;
	
	@ManyToOne
	@JoinColumn(name="categoryId",updatable=false,insertable=false,nullable=false)
	private Category category;

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}

	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

		
}
	