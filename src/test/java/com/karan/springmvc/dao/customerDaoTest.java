package com.karan.springmvc.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartFile;

import com.karan.springmvc.model.customer;

class customerDaoTest {
	private DriverManagerDataSource dataSource;
	private DriverManagerDataSource dataSource2;
	@Autowired
	private customerDao dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dao = new customerDaoImpl();
		dao.setJdbcTemplate(dataSource);
		dataSource2 = new DriverManagerDataSource();
		dataSource2.setDriverClassName("org.postgresql.Driver");
		dataSource2.setUrl("jdbc:postgresql://localhost:5432/op");
		dataSource2.setUsername("postgres");
		dataSource2.setPassword("root");
		dao.setJdbcTemplate1(dataSource2);
	}
	@Test
	void testCustomer_dtls() {
		List<customer> customer = dao.customer_dtls();
		System.out.println(customer);
		assertTrue(!customer.isEmpty());
	}

	@Test
	void testAddCustomer() throws IOException {
		customer cust = new customer();
		cust.setFirst_name("aaa");
		cust.setLast_name("thota");
		cust.setEmail("karafadfan@gmail.com");
		int result = dao.addCustomer(cust);
		assertTrue(result > 0);
	}

	@Test
	void testGetCustomerById() {
		customer cust = new customer();
		cust = dao.getCustomerById(7);
		assertTrue(cust != null);
	}

	@Test
	void testGetMaxid() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCustomer() throws IOException {
		customer cust = new customer();
		cust.setId(7);
		cust.setFirst_name("karan");
		cust.setLast_name("thota");
		cust.setEmail("karan@gmail.com");
		dao.updateCustomer(cust);
		assertTrue(true);
	}

	@Test
	void testDeleteCustomer() {
		dao.deleteCustomer(7);
		assertTrue(true);
	}

	@Test
	void testGetusers() {
		List<String> user = dao.getusers();
		assertTrue(!user.isEmpty());
	}

}
