package com.karan.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.springmvc.dao.customerDao;
import com.karan.springmvc.model.customer;

@Service("customerService")
public class customerServiceImpl implements customerService {
	@Autowired
	private customerDao customerDaoImpl;

	public List<customer> getCustomerList() {

		return customerDaoImpl.customer_dtls();
	}

	@Override
	public int addCustomer(customer cmr) {
		return customerDaoImpl.addCustomer(cmr);
	}

	@Override
	public customer getcustoemr(int id) {
		return customerDaoImpl.getCustomerById(id);
	}

	@Override
	public void updateCustomer(customer cust) {
		customerDaoImpl.updateCustomer(cust);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDaoImpl.deleteCustomer(id);
	}
	
	@Override
	public List<String> getlist() {
		return customerDaoImpl.getusers();
	}

}
