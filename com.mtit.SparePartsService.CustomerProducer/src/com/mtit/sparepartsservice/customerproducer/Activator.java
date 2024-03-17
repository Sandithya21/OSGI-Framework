package com.mtit.sparepartsservice.customerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("```````````````Customer Started````````````````");
		
		customerService cusService = new customerServiceImpl();
		serviceRegistration = bundleContext.registerService(customerService.class.getName(),cusService ,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("+++++ CUSTOMER SERVICE STOPPED +++++");
		serviceRegistration.unregister();
	}

}
