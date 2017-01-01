package com.electro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.daoimpl.SubCategoryDAOImpl;
import com.electro.model.SubCategory;


@Service
@Transactional
public class SubCategoryService {
	
	@Autowired
	SubCategoryDAOImpl subCategoryDAOImpl;

	public void addSubCategory(SubCategory subCategory)
	{
		subCategoryDAOImpl.addSubCategory(subCategory);
	}
	public List<SubCategory> getSubCategoryList()
	{
		return subCategoryDAOImpl.getSubCategoryList();
	}
	public SubCategory getSubCategoryById(int subCategoryId)
	{
		return subCategoryDAOImpl.getSubCategoryById(subCategoryId);
	}
	public void deleteSubCategory(int subCategoryId)
	{
		subCategoryDAOImpl.deleteSubCategory(subCategoryId);
	}
	
	public SubCategory getSubCategoryByName(String subCategoryName)
	{
		return subCategoryDAOImpl.getSubCategoryByName(subCategoryName);
	}
	
	public String getJsonList()
	{
		return subCategoryDAOImpl.getJsonList();

	}


	
	
}
