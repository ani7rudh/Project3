package com.electro.dao;

import java.util.List;

import com.electro.model.Category;

public interface CategoryDAO 
{
	public void addCategory(Category category);
	public List<Category> getCategoryList();
	public Category getCategoryById(int categoryId);
	public void deleteCategory(int categoryId);
	public Category getCategoryByName(String categoryName);
	public String getJsonList();

}
