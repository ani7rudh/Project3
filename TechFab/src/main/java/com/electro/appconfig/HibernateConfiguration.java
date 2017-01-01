package com.electro.appconfig;

	import java.io.IOException;
import java.util.Properties;
	 
	import javax.sql.DataSource;

    import org.apache.commons.dbcp.BasicDataSource;
    import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
    import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
    import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.electro.daoimpl.BrandDAOImpl;
import com.electro.daoimpl.CategoryDAOImpl;
import com.electro.daoimpl.ProductDAOImpl;
import com.electro.daoimpl.SubCategoryDAOImpl;
import com.electro.daoimpl.SupplierDAOImpl;
import com.electro.daoimpl.UserDetailsDAOImpl;
import com.electro.model.BillingAddress;
import com.electro.model.Brand;
import com.electro.model.Cart;
import com.electro.model.Category;
import com.electro.model.Product;
import com.electro.model.Role;
import com.electro.model.ShippingAddress;
import com.electro.model.SubCategory;
import com.electro.model.Supplier;
import com.electro.model.User;
import com.electro.model.UserDetails;
import com.electro.model.UserRole;
import com.electro.service.BrandService;
import com.electro.service.CategoryService;
import com.electro.service.ProductService;
import com.electro.service.SubCategoryService;
import com.electro.service.SupplierService;
import com.electro.service.UserDetailsService;

    
	 
    @Configuration
    @EnableTransactionManagement
    @ComponentScan( "com.electro" )
    

    public class HibernateConfiguration {
     
       
       
         
        @Bean(name = "dataSource")
        public DataSource getDataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUrl("jdbc:h2:tcp://localhost/~/TeckFab");
            dataSource.setUsername("anirudh");
            dataSource.setPassword("");
            
            Properties dproperties= new Properties();
            dproperties.setProperty("hibernate.show_sql", "true");
            dproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            dproperties.setProperty("hibernate.hbm2ddl.auto","update");
         
            return dataSource;
        }
         
        private Properties getHibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            properties.put("hibernate.hbm2ddl.auto","update");
            return properties;
        }
        
        @Autowired
        @Bean(name = "transactionManager")
        public HibernateTransactionManager getTransactionManager(
                SessionFactory sessionFactory) {
            HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                    sessionFactory);
         
            return transactionManager;
        }
        
        @Autowired
        @Bean(name = "sessionFactory")
        public SessionFactory getSessionFactory(DataSource dataSource) {
         
            LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
            sessionBuilder.addProperties(getHibernateProperties());
         
            sessionBuilder.addAnnotatedClasses(Category.class);
            sessionBuilder.addAnnotatedClasses(Supplier.class);
            sessionBuilder.addAnnotatedClasses(SubCategory.class);
            sessionBuilder.addAnnotatedClasses(Brand.class);
            sessionBuilder.addAnnotatedClasses(Product.class);
            
            sessionBuilder.addAnnotatedClasses(User.class);
            sessionBuilder.addAnnotatedClasses(Role.class);
           sessionBuilder.addAnnotatedClasses(Cart.class);
            sessionBuilder.addAnnotatedClasses(UserDetails.class);
            sessionBuilder.addAnnotatedClasses(UserRole.class);
          sessionBuilder.addAnnotatedClasses(BillingAddress.class);
            sessionBuilder.addAnnotatedClasses(ShippingAddress.class);



            return sessionBuilder.buildSessionFactory();
        }
        
        @Autowired
        @Bean(name = "categoryDAOImpl")
        public CategoryDAOImpl getCategoryDao(SessionFactory sessionFactory) {
        	return new CategoryDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="categoryService")
        public CategoryService getCategoryService() {
        	return new CategoryService();
        }
        
        
        @Autowired
        @Bean(name = "supplierDAOImpl")
        public SupplierDAOImpl getSupplierDao(SessionFactory sessionFactory) {
        	return new SupplierDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="supplierService")
        public SupplierService getSupplierService() {
        	return new SupplierService();
        }

        
        @Autowired
        @Bean(name = "subCategoryDAOImpl")
        public SubCategoryDAOImpl getSubCategoryDao(SessionFactory sessionFactory) {
        	return new SubCategoryDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="subCategoryService")
        public SubCategoryService getSubCategoryService() {
        	return new SubCategoryService();
        }
       
         @Autowired
        @Bean(name = "brandDAOImpl")
        public BrandDAOImpl getBrandDao(SessionFactory sessionFactory) {
        	return new BrandDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="brandService")
        public BrandService getBrandService() {
        	return new BrandService();
        }
        
       
        
        @Autowired
        @Bean(name = "productDAOImpl")
        public ProductDAOImpl getProductDao(SessionFactory sessionFactory) {
        	return new ProductDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="productService")
        public ProductService getProductService() {
        	return new ProductService();
        }
        
        @Autowired
        @Bean(name = "userDetailsDAOImpl")
        public UserDetailsDAOImpl getUserDetailsDao(SessionFactory sessionFactory)
        {
        	return new UserDetailsDAOImpl(sessionFactory);
        }
        
        @Autowired
        @Bean(name="userDetailsService")
        public UserDetailsService getUserDetailsService()
        {
        	return new UserDetailsService();
        }
        
        
        
        
        
       
        @Autowired
        @Bean(name="multipartResolver") 
    	public CommonsMultipartResolver getResolver() throws IOException{
    		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	    resolver.setDefaultEncoding("utf-8");

    		  return resolver;
    	}


     
    }
