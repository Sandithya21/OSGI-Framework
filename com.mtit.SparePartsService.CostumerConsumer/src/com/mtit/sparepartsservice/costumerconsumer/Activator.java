package com.mtit.sparepartsservice.costumerconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.sparepartsservice.customerproducer.customerService;


import java.util.*;

public class Activator implements BundleActivator {
	
	ServiceReference servicereference;
	Scanner scan = new Scanner(System.in);
	boolean exit = false;

	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("############Customer Consumer Started################");
		servicereference = bundleContext.getServiceReference(customerService.class.getName());
		@SuppressWarnings("unchecked")
		customerService customerservice = (customerService) bundleContext.getService(servicereference);
		
		System.out.println("(1).User Registration");
		System.out.println("(2).User Update");
		System.out.println("(3).User Delete");
		System.out.println("(4).Display your details");
		System.out.println("(5).Exit");
		
		System.out.println("###Please Enter your option : ");
		int option = scan.nextInt();
		scan.nextLine();
		
		while(option != 5) {
			
		
			if(option == 1) {
			
				System.out.println("Enter User Details");
				System.out.println("Enter User name: ");
				String username = scan.next();
				System.out.println("Enter password: ");
				String password = scan.next();
				System.out.println("Enter your age: ");
				String age = scan.next();
				System.out.println("Enter your address: ");
				String address = scan.next();
				
				scan.nextLine();
				
				int output = customerservice.addCustomer(username, password, age, address);
				
				if(output == 1) {
					System.out.println("Customer added successfully");
					customerservice.getCustomerDet(username);
					
					
				}else {
					System.out.println("Customer added unsuccess");
				}
				
				}
			else if(option == 2) {
				
				System.out.println("***Please Login to the System first***");
				
				System.out.println("Enter User Name : ");
				String name = scan.next();
				
				System.out.println("Enter Password: ");
				String pw = scan.next();
				
				if(customerservice.customerLogin(name, pw)==true) {
					System.out.println("####Update User details####");
					
					System.out.println("Enter your new Username:");
					String newName = scan.next();
				
					System.out.println("Enter your updated password:");
					String ps = scan.next();
					
					System.out.println("Enter your updated age:");
					String age = scan.next();
					
					System.out.println("Enter your updated Address:");
					String address = scan.next();
					
					
					scan.nextLine();
					
					
					int output = customerservice.updateCustomer(name,newName, ps, age, address);
					if(output==1) {
						System.out.println("User updated Successfully");
					}else {
						System.out.println("user update unsuccess");
					}
					
				}else {
					System.out.println("Username or Password incorrect");
					}
				}
				
				
			else if(option == 4) {
				System.out.println("***Please enter your usernasme first***");
				
				System.out.println("\tEnter User Name : ");
				String name = scan.next();
				
				//System.out.println("Enter Password: ");
				//String pw = scan.next();
				customerservice.getCustomerDet(name);
			}
			System.out.println("(2).User Update");
			System.out.println("(3).User Delete");
			System.out.println("(4).Display your details");
			System.out.println("(5).Exit");
			
			System.out.println("###Please Enter your option : ");
			option = scan.nextInt();
			scan.nextLine();
		}
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========CUSTOMER CONSUMER STOPPED==========");
		bundleContext.ungetService(servicereference);
	}

}
