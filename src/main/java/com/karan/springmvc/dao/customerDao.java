package com.karan.springmvc.dao;

import java.util.List;
import com.karan.springmvc.model.customer;

public interface customerDao {
	public List<customer> customer_dtls();

	public int addCustomer(customer cmr);
	
	public customer getCustomerById(int id);
	
	public customer getMaxid();

	public void updateCustomer(customer cust);
	
	public void deleteCustomer(int id);
}
