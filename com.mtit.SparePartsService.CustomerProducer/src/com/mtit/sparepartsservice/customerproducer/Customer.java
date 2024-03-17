package com.mtit.sparepartsservice.customerproducer;

public class Customer {
	
	public String cName;
	public String password;
	private String age;
	private String Address;
	
	public Customer(String cName, String password, String age, String Address) {
		
		this.cName = cName;
		this.password = password;
		this.age=age;
		this.Address=Address;	
	}
	
	public String getName() {
		return cName;
	}
	public String getPassword() {
		return password;
	}
	public String getAge() {
		return age;
	}
	public String getAddress() {
		return Address;
	}
	public void setName(String name) {
		this.cName = name;
	}
	public void setPassword(String ps) {
		this.password = ps;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	

}
