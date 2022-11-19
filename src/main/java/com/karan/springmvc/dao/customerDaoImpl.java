package com.karan.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.karan.springmvc.model.customer;
import com.karan.springmvc.resultsetExtractor.customerResultSetExtractor;

@Repository("customerDao")
public class customerDaoImpl implements customerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<customer> customer_dtls() {				
		String sql = "SELECT id,first_name,last_name,email FROM customer";
		List<customer> cst=jdbcTemplate.query(sql, new customerResultSetExtractor());
		return cst;
	}

	public int addCustomer(customer cmr) {
		int k=0;
		String sql = "INSERT INTO customer(first_name,last_name,email) values(?,?,?)";
		Object[] arg = {cmr.getFirst_name(),cmr.getLast_name(),cmr.getEmail()};
		k = jdbcTemplate.update(sql, arg);
		return k;
	}
	
	
	@Override
	public customer getMaxid() {
		String sql = "SELECT MAX(id) FROM customer";
		return (customer) jdbcTemplate.query(sql, new RowMapper<customer>() {
			public customer mapRow(ResultSet rs, int rownumber) throws SQLException {
				customer cmr = new customer();
				if(rs.next()) {
					cmr.setId(rs.getInt("max"));
				}
				return cmr;
			}
		});
	}

	@Override
	public customer getCustomerById(int id) {
		String sql = "SELECT * FROM customer WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<customer>(customer.class),id);
	}

	@Override
	public void updateCustomer(customer cust) {
		String sql = "UPDATE customer SET first_name=?,last_name=?,email=? WHERE id=?";
		jdbcTemplate.update(sql,cust.getFirst_name(),cust.getLast_name(),cust.getEmail(),cust.getId());
	}

	@Override
	public void deleteCustomer(int id) {
		String sql ="DELETE FROM customer WHERE id=?";
		jdbcTemplate.update(sql,id);
		
	}
}