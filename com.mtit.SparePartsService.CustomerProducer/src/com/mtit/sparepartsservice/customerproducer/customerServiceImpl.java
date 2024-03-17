package com.mtit.sparepartsservice.customerproducer;

public class customerServiceImpl implements customerService {

	Customer newCustomer;
	@Override
	public synchronized int addCustomer(String cName, String password, String age, String Address) {
		newCustomer = new Customer(cName,password,age,Address);

        return 1;
	}

	@Override
	public synchronized int updateCustomer(String cName,String newName, String password, String age, String Address) {
		String name = cName;
        if (newCustomer.getName() == name) {
        	Customer newCustomer1 = null;
        	newCustomer = newCustomer1;
        	newCustomer1 = new Customer(newName,password,age,Address);
            return 1;
        } else {
            return 0;
        }
	}

	@Override
	public int removeCustomer(String cName, String password) {
		newCustomer = null;
		
		if(newCustomer==null) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public synchronized int getCustomerName(String cnName) {
		if(newCustomer.getName()==cnName) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public synchronized void getCustomerDet(String cName) {
		if(newCustomer!=null) {
			System.out.println("Username:"+newCustomer.getName());
			System.out.println("Password:"+newCustomer.getPassword());
			System.out.println("Age:"+newCustomer.getAge());
			System.out.println("Address:"+newCustomer.getAddress());
		}else {
			System.out.println("Customer Not Found");
		}
		
	}

	@Override
	public synchronized boolean customerLogin(String cName, String pw) {
		if(newCustomer.cName==cName && newCustomer.password==pw) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
