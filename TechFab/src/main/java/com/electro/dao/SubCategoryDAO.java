package com.electro.dao;

import java.util.List;

import com.electro.model.SubCategory;


public interface SubCategoryDAO {
	public void addSubCategory(SubCategory subCategory);
	public List<SubCategory> getSubCategoryList();
	public SubCategory getSubCategoryById(int subCategoryId);
	public void deleteSubCategory(int subCategoryId);
	public SubCategory getSubCategoryByName(String subCategoryName);
	public String getJsonList();


}
