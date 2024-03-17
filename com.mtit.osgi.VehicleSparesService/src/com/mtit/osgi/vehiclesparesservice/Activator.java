package com.mtit.osgi.vehiclesparesservice;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator, ServiceListener {

	private DictionaryService service;
	private ServiceTracker<DictionaryService, ?> dictionaryServiceTracker;
	private BundleContext fContext;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("==== Start MTIT Osgi Vehicle Spare Service ====");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("==== Stop MTIT Osgi Vehicle Spare Service ====");
	}

	public void serviceChanged(ServiceEvent ev) {
		ServiceReference<?> sr = ev.getServiceReference();
		switch(ev.getType()) {
			case ServiceEvent.REGISTERED:
			{
				Dictionary dictionary = (Dictionary) fContext.getService(sr);
				service.registerDictionary(dictionary);
			}
			break;
			case ServiceEvent.UNREGISTERING:
			{
				Dictionary dictionary = (Dictionary) fContext.getService(sr);
				service.unregisterDictionary(dictionary);
			}
			break;
		}
	}


}
