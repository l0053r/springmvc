package com.karan.springmvc.resultsetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.karan.springmvc.model.customer;

public class customerResultSetExtractor implements ResultSetExtractor<List<customer>> {

	public List<customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<customer> customerList = new ArrayList<customer>();
		while(rs.next()) {
			customer cst = new customer();
			cst.setId(rs.getInt("id"));
			cst.setFirst_name(rs.getString("first_name"));
			cst.setLast_name(rs.getString("last_name"));
			cst.setEmail(rs.getString("email"));
			cst.setGender(rs.getString("gender"));
			String food = rs.getString("food");			
			String[] lst = null;
			if(food != null) {
				food.replace('{', ' ');
				food.replace('}', ' ');
				lst = food.split(",");
			}
			cst.setFood(lst);
			cst.setCityFrom(rs.getString("cityfrom"));
			cst.setCityTo(rs.getString("cityto"));
			customerList.add(cst);
		}
		
		return customerList;
	}
	public int maxid(ResultSet rs) throws SQLException, DataAccessException {
		int id = 0;
		if(rs.next()) {
			id= rs.getInt("max");
		}		
		return id;
	}

}
