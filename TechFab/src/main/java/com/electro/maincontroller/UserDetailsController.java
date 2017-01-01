package com.electro.maincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.electro.model.BillingAddress;
import com.electro.model.ShippingAddress;
import com.electro.model.UserDetails;
import com.electro.service.UserDetailsService;

@Controller
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login")
	public String LoginPage(Model model)
	{
		
	
		return "Login";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	

	
	
	@RequestMapping(value = "/registration")
	   public String RegistrationPage(Model model) {
		
		//model.addAttribute("userDetails", new UserDetails());
				UserDetails userDetails=new UserDetails();
				BillingAddress billingAddress =new BillingAddress();
				ShippingAddress shippingAddress= new ShippingAddress();
				
				userDetails.setBillingAddress(billingAddress);
				userDetails.setShippingAddress(shippingAddress);
				model.addAttribute("userDetails", userDetails);
				
				return "Registration";
	}
	
	@RequestMapping(value = "/addUserDetails")
	public String addUserDetails(@ModelAttribute("userDetails")UserDetails userDetails)
	{
      userDetailsService.addUserDetails(userDetails);
		return "redirect:/registration";
	}


	
	


}
