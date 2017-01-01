package com.electro.maincontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electro.model.Supplier;
import com.electro.service.SupplierService;



@Controller
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/supplier")
	   public String Supplier(Model model) {
		
		model.addAttribute("supplier",new Supplier());
//		model.addAttribute("supplierList",supplierService.getSupplierList());
		model.addAttribute("supplierList",supplierService.getJsonList());

	
	    return "Supplier";
	   }
	
	 @RequestMapping(value = "/addSupplier")
	   public String addSupplier(Model model,@Valid@ModelAttribute("supplier")Supplier supplier,BindingResult result) {
	     
		 if(result.hasErrors())
	     {
				model.addAttribute("supplierList",supplierService.getJsonList());
			    return "Supplier";


	     }
		 else
		 {
	      supplierService.addSupplier(supplier);
	      
	      return "redirect:/supplier";
	   }}
	
	 @RequestMapping(value ="editSupplier-{supplierId}")
	   
	   public String editSupplier(Model model,@PathVariable("supplierId") int supplierId)
	   {
		   model.addAttribute("supplier",supplierService.getSupplierById(supplierId));
			model.addAttribute("supplierList",supplierService.getJsonList());

		   return "Supplier";
	   }
	 
	 @RequestMapping(value="deleteSupplier-{supplierId}")
	   public String deleteSupplier(@PathVariable("supplierId") int supplierId)
	   {
		   supplierService.deleteSupplier(supplierId);
		   return "redirect:/supplier";
	   }

	   
	

}
