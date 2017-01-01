package com.electro.maincontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electro.model.Brand;
import com.electro.service.BrandService;

@Controller
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@RequestMapping(value = "/brand")
	   public String Brand(Model model) {
		
		model.addAttribute("brand",new Brand());
//		model.addAttribute("brandList",brandService.getBrandList());
		model.addAttribute("brandList",brandService.getJsonList());

	    return "Brand";
	    }

	@RequestMapping(value = "/addBrand")
	   public String addBrand(Model model,@Valid@ModelAttribute("brand")Brand brand,BindingResult result) {
		 if(result.hasErrors())
	     {
				model.addAttribute("brandList",brandService.getJsonList());

	    	 return "Brand";
	     }
	     else{

	     
	      brandService.addBrand(brand);
	     }
	      return "redirect:/brand";
	   }
	   
	@RequestMapping(value ="editBrand-{brandId}")
	   
	   public String editBrand(Model model,@PathVariable("brandId")int brandId)
	   {
		   model.addAttribute("brand",brandService.getBrandById(brandId));
			model.addAttribute("brandList",brandService.getJsonList());

		   return "Brand";
	   }
	   

	   
	   @RequestMapping(value="deleteBrand-{brandId}")
	   public String deleteBrand(@PathVariable("brandId") int brandId)
	   {
		   brandService.deleteBrand(brandId);
		   return "redirect:/brand";
	   }

	
	
}
