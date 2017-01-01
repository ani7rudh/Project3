package com.electro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.daoimpl.BrandDAOImpl;
import com.electro.model.Brand;

@Service
@Transactional
public class BrandService {
	@Autowired
	BrandDAOImpl brandDAOImpl;
	
	
	public void addBrand(Brand brand){
		brandDAOImpl.addBrand(brand);
	}
	public List<Brand> getBrandList(){
		return brandDAOImpl.getBrandList();
	}
	public Brand getBrandById(int brandId){
		return brandDAOImpl.getBrandById(brandId);
	}
	public void deleteBrand(int brandId){
		brandDAOImpl.deleteBrand(brandId);
	}
	
	public Brand getBrandByName(String brandName) {
		return brandDAOImpl.getBrandByName(brandName);
	}
	
	public String getJsonList()
	{
		return brandDAOImpl.getJsonList();
	}

	
	}



