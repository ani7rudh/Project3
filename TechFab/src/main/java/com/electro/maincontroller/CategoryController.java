package com.electro.maincontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electro.model.Category;
import com.electro.service.CategoryService;

@Controller

public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/category")
	   public String Category(Model model) {
		
		model.addAttribute("category",new Category());
//	model.addAttribute("categoryList",categoryService.getCategoryList());
	model.addAttribute("categoryList",categoryService.getJsonList());

	
	    return "Category";
	      
	      
	   }
	
	
	   
	   @RequestMapping(value = "/addCategory")
	   public String addCategory(Model model,@Valid@ModelAttribute("category")Category category,BindingResult result) {
	     if(result.hasErrors())
	     {
	    		model.addAttribute("categoryList",categoryService.getJsonList());

	    	 return "Category";
	     }
	     else{
	      categoryService.addCategory(category);
	      
	      return "redirect:/category";
	     }
	   }
	   
	   @RequestMapping(value ="editCategory-{categoryId}")
	   
	   public String editCategory(Model model,@PathVariable("categoryId")int categoryId)
	   {
		   model.addAttribute("category",categoryService.getCategoryById(categoryId));
			model.addAttribute("categoryList",categoryService.getJsonList());

		   return "Category";
	   }
	   

	   
	   @RequestMapping(value="deleteCategory-{categoryId}")
	   public String deleteCategory(@PathVariable("categoryId") int categoryId)
	   {
		   categoryService.deleteCategory(categoryId);
		   return "redirect:/category";
	   }
}
