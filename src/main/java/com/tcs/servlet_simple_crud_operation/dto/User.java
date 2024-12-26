package com.tcs.servlet_simple_crud_operation.dto;

import java.time.LocalDate;

public class User {
private int id;
private String name;
private String email;
private LocalDate dob;
private String gender;
private String password;


public User() {
	super();
}
public User(int id, String name, String email, LocalDate dob,String gender, String password ) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.password=password;
	
}



public User(int id, String name, String email, LocalDate dob, String gender) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
}
public User(String email, String password) {
	this.email = email;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", gender=" + gender + " ,password=" + password + "]";
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
