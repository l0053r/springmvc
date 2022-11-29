package com.karan.springmvc.service;

import java.io.IOException;
import java.util.List;

import com.karan.springmvc.model.customer;

public interface customerService {

	List<customer> getCustomerList();

	int addCustomer(customer cmr) throws IOException;
	
	customer getcustoemr(int id);

	void updateCustomer(customer cust) throws IOException;
	
	void deleteCustomer(int id);
	
	List<String> getlist();
	
	byte [] getImageById(int id);

}
