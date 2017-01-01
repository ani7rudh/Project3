package com.electro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.electro.dao.ProductDAO;
import com.electro.model.Product;
import com.google.gson.Gson;

public class ProductDAOImpl implements ProductDAO{
	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public List<Product> getProductList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).list();
		return plist;	}

	public Product getProductById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product where productId="+productId;
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).list();
		return plist.get(0);

	}


	public void deleteProduct(int productId) {
		Product producttodelete=new Product();
		producttodelete.setProductId(productId);
		sessionFactory.getCurrentSession().delete(producttodelete);
	}


	public String getJsonList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> plist=session.createQuery(hql).list();
		Gson gson=new Gson();
		String jsonList=gson.toJson(plist);
		
		return jsonList;
		
	}

}
