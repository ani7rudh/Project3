package com.electro.maincontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.electro.model.Brand;
import com.electro.model.Category;
import com.electro.model.Product;
import com.electro.model.SubCategory;
import com.electro.model.Supplier;
import com.electro.service.BrandService;
import com.electro.service.CategoryService;
import com.electro.service.ProductService;
import com.electro.service.SubCategoryService;
import com.electro.service.SupplierService;

@Controller
public class ProductController {
	
	
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	SupplierService supplierService;

	
	
	@RequestMapping(value = "/product")
	   public String Product(Model model) {
		
		model.addAttribute("product",new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("subCategory",new SubCategory());
		model.addAttribute("brand",new Brand());
		model.addAttribute("supplier",new Supplier());

//		model.addAttribute("productList",productService.getProductList());
		model.addAttribute("categoryList",categoryService.getCategoryList());
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		model.addAttribute("brandList",brandService.getBrandList());
		model.addAttribute("supplierList",supplierService.getSupplierList());

		model.addAttribute("productList",productService.getJsonList());

//		model.addAttribute("categoryList",categoryService.getJsonList());
//	    model.addAttribute("subCategoryList",subCategoryService.getJsonList());
//		model.addAttribute("brandList",brandService.getJsonList());
//		model.addAttribute("supplierList",supplierService.getJsonList());

		
		
		
		
		
		
		
		
		
	
	    return "Product";
	      
	      
	   }
	
	
	   
	   @RequestMapping(value = "/addProduct")
	   public String addProduct(Model model,@Valid@ModelAttribute("product")Product product,BindingResult result) {
		   if(result.hasErrors())
		   {
				model.addAttribute("productList",productService.getJsonList());

			    return "Product";

		   }
		   else{
			Category category=categoryService.getCategoryByName(product.getCategory().getCategoryName());
			SubCategory subCategory=subCategoryService.getSubCategoryByName(product.getSubCategory().getSubCategoryName());
			Brand brand=brandService.getBrandByName(product.getBrand().getBrandName());
			Supplier supplier=supplierService.getSupplierByName(product.getSupplier().getSupplierName());

			product.setCategory(category);
			product.setCategoryId(category.getCategoryId());
			
			product.setSubCategory(subCategory);
			product.setSubCategoryId(subCategory.getSubCategoryId());
			
			product.setBrand(brand);
			product.setBrandId(brand.getBrandId());
			
			product.setSupplier(supplier);
			product.setSupplierId(supplier.getSupplierId());
			
			



	     
	      productService.addProduct(product);
	      
	      String path="D:\\DT Project\\TechFab\\src\\main\\webapp\\resources\\images\\";
			path=path+String.valueOf(product.getProductId())+".jpg";
			File f=new File(path);
			MultipartFile filedet=product.getProductImage();
			try {
				byte[] bytes=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(bytes);
				bos.close();
				System.out.println("File uploaded successfully");
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
	      
	      	      return "redirect:/product";
	   }
	   }
	   
	   @RequestMapping(value ="editProduct-{productId}")
	   
	   public String editProduct(Model model,@PathVariable("productId")int productId)
	   {
		   model.addAttribute("product",productService.getProductById(productId));
		   model.addAttribute("categoryList",categoryService.getCategoryList());
			model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
			model.addAttribute("brandList",brandService.getBrandList());
			model.addAttribute("supplierList",supplierService.getSupplierList());
			model.addAttribute("productList",productService.getJsonList());

		   return "Product";
	   }
	   

	   
	   @RequestMapping(value="deleteProduct-{productId}")
	   public String deleteProduct(@PathVariable("productId") int productId)
	   {
		   productService.deleteProduct(productId);
		   return "redirect:/product";
	   }
	

}
