package com.karan.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karan.springmvc.model.customer;
import com.karan.springmvc.service.customerService;

@Controller
public class customerController {
	@Autowired
	private customerService customerServiceImpl;
	
	@RequestMapping(value = "/viewcustomer",method = RequestMethod.GET)	
	public String getcustomer(Model model) {		
		List<customer> cst = customerServiceImpl.getCustomerList();
		model.addAttribute("customerlist",cst);
		return "customerView";
	}
	
	@RequestMapping(value = "/customerform",method = RequestMethod.GET)
	public String addpage(Model model) {
		customer Customer = new customer();
		model.addAttribute("customer",Customer);
		return "customerForm";
	}
	
	@RequestMapping(value = "/addcustomer",method = RequestMethod.POST)
	public String addcustomer(@ModelAttribute("customer") customer cust) {		
		customerServiceImpl.addCustomer(cust);
		return "redirect:customerform";
	}
	
	@RequestMapping(value = "/editcust/{id}",method = RequestMethod.GET)
	public String getcustomerbyid(@PathVariable int id,Model model) {
		customer cust =  customerServiceImpl.getcustoemr(id);
		model.addAttribute("customer",cust);
		return "customerEdit";
	}
	
	@RequestMapping(value = "/editcust/editcustomer",method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute("customer") customer cust) {		
		customerServiceImpl.updateCustomer(cust);
		return "redirect:/viewcustomer";
	}
	
	@RequestMapping(value = "/deletecust/{id}",method = RequestMethod.GET)
	public String deletecustomerbyid(@PathVariable int id,Model model) {
		customerServiceImpl.deleteCustomer(id);
		return "redirect:/viewcustomer";
	}
	
	@RequestMapping("/op")
	public String getop(Model model) {		
		List<String> list = new ArrayList<String>();
		list = customerServiceImpl.getlist(); 
		model.addAttribute("list",list);
		return "test";
	}
}
