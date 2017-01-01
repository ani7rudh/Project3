package com.electro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.daoimpl.CategoryDAOImpl;
import com.electro.model.Category;
@Service
@Transactional
public class CategoryService
{
	@Autowired
	CategoryDAOImpl categoryDAOImpl;

	public void addCategory(Category category)
	{
		categoryDAOImpl.addCategory(category);
	}
	
	public List<Category> getCategoryList()
	{
		return categoryDAOImpl.getCategoryList();
		
	}
	public Category getCategoryById(int categoryId)
	{
		return categoryDAOImpl.getCategoryById(categoryId);

	}
	public void deleteCategory(int categoryId)
	{
		categoryDAOImpl.deleteCategory(categoryId);
	}

	public Category getCategoryByName(String categoryName) {
	    return categoryDAOImpl.getCategoryByName(categoryName);
		}
	
	public String getJsonList() {
return categoryDAOImpl.getJsonList();
	}
}
	

