package oderproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import order_service_impl.OrderServiceImpl;
import order_service_interface.IOrderService;

public class ServiceActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("+++++ ORDER SERVICE STARTED +++++");
		
		IOrderService OrderService = new OrderServiceImpl();
		//REGISTER THE DIRECTOR SERVICE
		serviceRegistration = bundleContext.registerService(IOrderService.class.getName().toString(), OrderService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("+++++ ORDER SERVICE STOPPED +++++");
		serviceRegistration.unregister();
	}

}
