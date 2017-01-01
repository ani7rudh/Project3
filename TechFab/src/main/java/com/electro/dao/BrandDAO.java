package com.electro.dao;

import java.util.List;

import com.electro.model.Brand;


public interface BrandDAO {
	public void addBrand(Brand brand);
	public List<Brand> getBrandList();
	public Brand getBrandById(int brandId);
	public void deleteBrand(int brandId);
	public Brand getBrandByName(String brandName);
	public String getJsonList();

	
}
