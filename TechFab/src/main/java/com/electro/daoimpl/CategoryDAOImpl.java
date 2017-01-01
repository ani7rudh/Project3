package com.electro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electro.dao.CategoryDAO;
import com.electro.model.Category;
import com.google.gson.Gson;
@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void addCategory(Category category)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}

	public List<Category> getCategoryList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category";
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).list();
		return clist;
		

	}

	public Category getCategoryById(int categoryId) {
		
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category where categoryId="+categoryId;
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).list();
		return clist.get(0);
	}

	public void deleteCategory(int categoryId) {
		Category categorytodelete=new Category();
		categorytodelete.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(categorytodelete);
		
	}

	public Category getCategoryByName(String categoryName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category where categoryname="+"'"+categoryName+"'";
		@SuppressWarnings("unchecked")
		List<Category> sclist=session.createQuery(hql).list();
		return sclist.get(0);
	}

	public String getJsonList() {
		
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category";
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).list();
		
		Gson gson=new Gson();
		String jsonList=gson.toJson(clist);
		
		return jsonList;
		
		
	}

}
