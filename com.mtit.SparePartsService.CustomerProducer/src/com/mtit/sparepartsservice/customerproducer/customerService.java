package com.mtit.sparepartsservice.customerproducer;

public interface customerService {
	public int addCustomer(String cName,String password,String age,String Address);
	public int updateCustomer(String cName,String newName,String password,String age,String Address);
	public int removeCustomer(String cName,String password);
	public int getCustomerName(String cnName);
	public void getCustomerDet(String cName);
	public boolean customerLogin(String cName,String pw);


}
