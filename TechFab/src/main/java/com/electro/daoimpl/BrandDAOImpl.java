package com.electro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electro.dao.BrandDAO;
import com.electro.model.Brand;
import com.google.gson.Gson;

@Repository
public class BrandDAOImpl implements BrandDAO{

	@Autowired
	SessionFactory sessionFactory;

	public BrandDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	
	public void addBrand(Brand brand) {
		sessionFactory.getCurrentSession().saveOrUpdate(brand);
		
	}

	public List<Brand> getBrandList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Brand";
		@SuppressWarnings("unchecked")
		List<Brand> blist=session.createQuery(hql).list();
		return blist;

	}

	public Brand getBrandById(int brandId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Brand where brandId="+brandId;
		@SuppressWarnings("unchecked")
		List<Brand> blist=session.createQuery(hql).list();
		return blist.get(0);
	}

	public void deleteBrand(int brandId) {
		Brand brandtodelete=new Brand();
		brandtodelete.setBrandId(brandId);
		sessionFactory.getCurrentSession().delete(brandtodelete);
				
	}


	public Brand getBrandByName(String brandName) {

		Session session=sessionFactory.getCurrentSession();
		String hql="from Brand where brandName="+"'"+brandName+"'";
		@SuppressWarnings("unchecked")
		List<Brand> blist=session.createQuery(hql).list();
		return blist.get(0);
	}


	public String getJsonList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Brand";
		@SuppressWarnings("unchecked")
		List<Brand> blist=session.createQuery(hql).list();
		
		Gson gson=new Gson();
		String jsonList=gson.toJson(blist);
		
		return jsonList;
		
	}

}
