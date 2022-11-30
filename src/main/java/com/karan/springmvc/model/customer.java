package com.karan.springmvc.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class customer {
	private int id;
	@NotNull(message = "first name required")
	@Size(min=1,message="first name required")
	private String first_name;
	@NotNull(message = "last name required")
	@Size(min=1,message = "last name required")
	private String last_name;
	@NotEmpty(message = "email is required")
	@Email(message = "enter valid email address")
	private String email;
	@NotNull(message = "gender is required")
	private String Gender;
	private String[] food;
	private String cityFrom;
	private String cityTo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "date is required")
	@Past(message = "invalid date!")
	private Date confirm_date;
	private MultipartFile file;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String[] getFood() {
		return food;
	}
	public void setFood(String[] food) {
		this.food = food;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public Date getConfirm_date() {
		return confirm_date;
	}
	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
