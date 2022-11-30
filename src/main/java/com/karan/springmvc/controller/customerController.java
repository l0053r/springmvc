package com.karan.springmvc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.karan.springmvc.model.customer;
import com.karan.springmvc.service.customerService;
import com.karan.springmvc.validator.customerValidator;

@Controller
public class customerController {
	private static Logger log = Logger.getLogger(customerController.class);
	@Autowired
	private customerValidator customerValidator;
	@Autowired
	private customerService customerServiceImpl;
	

	@RequestMapping(value = "/viewcustomer", method = RequestMethod.GET)
	public String getcustomer(Model model) {
		log.debug("Inside getcustomer method");
		List<customer> cst = customerServiceImpl.getCustomerList();
		model.addAttribute("customerlist", cst);
		log.info("result success");
		return "customerView";
	}

	@RequestMapping(value = "/customerform", method = RequestMethod.GET)
	public String addpage(Model model) {
		model.addAttribute("customer", new customer());
		return "customerForm";
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addcustomer( @ModelAttribute("customer") @Valid customer cust, BindingResult result, Model m) throws IOException {
		customerValidator.validate(cust, result);
		if(result.hasErrors()) {
			return "customerForm";
		}
		int i = customerServiceImpl.addCustomer(cust);
		System.out.println(i);
		switch (i) {
		case 0:
			m.addAttribute("msg", "something went wrong");
			break;
		case 1:
			m.addAttribute("msg", "data updated successfully");
			break;
		}
		m.addAttribute("customer", new customer());
		return "customerForm";
	}

	@RequestMapping(value = "/editcust/{id}", method = RequestMethod.GET)
	public String getcustomerbyid(@PathVariable int id, Model model) {
		customer cust = customerServiceImpl.getcustoemr(id);
		model.addAttribute("customer", cust);
		return "customerEdit";
	}

	@RequestMapping(value = "/editcust/editcustomer", method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute("customer") customer cust) throws IOException {
		customerServiceImpl.updateCustomer(cust);
		return "redirect:/viewcustomer";
	}

	@RequestMapping(value = "/deletecust/{id}", method = RequestMethod.GET)
	public String deletecustomerbyid(@PathVariable int id, Model model) {
		customerServiceImpl.deleteCustomer(id);
		return "redirect:/viewcustomer";
	}

	@RequestMapping("/op")
	public String getop(Model model) {
		List<String> list = new ArrayList<String>();
		list = customerServiceImpl.getlist();
		model.addAttribute("list", list);
		return "test";
	}

	@RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET)
	public void getImageById(@PathVariable int id, HttpServletResponse response, Model model) throws IOException {
		byte[] imageBytes = customerServiceImpl.getImageById(id);
		response.setContentType("image/jpg");
		OutputStream out = response.getOutputStream();
		out.write(imageBytes);
	}
}
