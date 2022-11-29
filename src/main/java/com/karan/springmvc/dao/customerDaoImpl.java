package com.karan.springmvc.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.karan.springmvc.model.customer;
import com.karan.springmvc.resultsetExtractor.customerResultSetExtractor;

@Repository("customerDao")
public class customerDaoImpl implements customerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate1;
	
	public void setJdbcTemplate(DriverManagerDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);		
	}
	public void setJdbcTemplate1(DriverManagerDataSource dataSource) {
		this.jdbcTemplate1 = new JdbcTemplate(dataSource);		
	}

	public List<customer> customer_dtls() {				
		String sql = "SELECT id,first_name,last_name,email,gender,food,cityfrom,cityto FROM customer";
		List<customer> cst=jdbcTemplate.query(sql, new customerResultSetExtractor());
		return cst;
	}
	
	@Override
	public int addCustomer(customer cmr) throws IOException {
		int k=0;
		byte[] photByte = cmr.getFile().getBytes();
		String food = Arrays.toString(cmr.getFood());
		food = food.replace("[", "");
		food = food.replace("]", "");
		String sql = "INSERT INTO customer(first_name,last_name,email,gender,food,cityfrom,cityto,profile) values(?,?,?,?,?,?,?,?)";
		Object[] arg = {cmr.getFirst_name(),cmr.getLast_name(),cmr.getEmail(),cmr.getGender(),food,cmr.getCityFrom(),cmr.getCityTo(),photByte};
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
	public void updateCustomer(customer cust) throws IOException {
		String food = Arrays.toString(cust.getFood());
		food = food.replace("[", "");
		food = food.replace("]", "");
		String sql = "UPDATE customer SET first_name=?,last_name=?,email=?,gender=?,food=?,cityfrom=?,cityto=?";
		System.out.println(cust.getFile());
		byte [] imageByte = null;
		if(cust.getFile()!=null) {
			imageByte = cust.getFile().getBytes();
			sql = sql +",profile=?";			
		};
		sql= sql+" WHERE id=?";
		if(cust.getFile()!=null) {
			jdbcTemplate.update(sql,cust.getFirst_name(),cust.getLast_name(),cust.getEmail(),cust.getGender(),food,cust.getCityFrom(),cust.getCityTo(),imageByte,cust.getId());
		}else {
			jdbcTemplate.update(sql,cust.getFirst_name(),cust.getLast_name(),cust.getEmail(),cust.getGender(),food,cust.getCityFrom(),cust.getCityTo(),cust.getId());
		}
	}

	@Override
	public void deleteCustomer(int id) {
		String sql ="DELETE FROM customer WHERE id=?";
		jdbcTemplate.update(sql,id);
		
	}
	
	public List<String> getusers(){
		String sql ="SELECT * from dir_users";
		return jdbcTemplate1.queryForObject(sql, new RowMapper<List<String>>() {
			public List<String> mapRow(ResultSet rs,int rown) throws SQLException {
				List<String> newlist = new ArrayList<>();
					String name = "";
						while(rs.next()) {
							name=rs.getString("user_id");
							newlist.add(name);
						}
				return newlist;
			}
		});
		
	}
	@Override
	public byte[] getImageById(int id) {
		String sql ="SELECT profile FROM customer WHERE id=?";
		Object[] args = {id};
		return jdbcTemplate.queryForObject(sql, args, byte[].class);		
	}	
}