package com.karan.springmvc.dao;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.karan.springmvc.model.customer;

public interface customerDao {
	public List<customer> customer_dtls();

	public int addCustomer(customer cmr);
	
	public customer getCustomerById(int id);
	
	public customer getMaxid();

	public void updateCustomer(customer cust);
	
	public void deleteCustomer(int id);

	public List<String> getusers();

	public void setJdbcTemplate(DriverManagerDataSource dataSource);

	public void setJdbcTemplate1(DriverManagerDataSource dataSource);
}
