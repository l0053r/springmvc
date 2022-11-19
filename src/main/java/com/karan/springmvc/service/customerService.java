package com.karan.springmvc.service;

import java.util.List;

import com.karan.springmvc.model.customer;

public interface customerService {

	List<customer> getCustomerList();

	int addCustomer(customer cmr);
	
	customer getcustoemr(int id);

	void updateCustomer(customer cust);
	
	void deleteCustomer(int id);

}
