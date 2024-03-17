package vehiclesparesserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import supplier_service_interface.ISupplierService;
import supplier_service_impl.SupplierServiceImpl;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("+++++ SPARE PARTS SERVICE STARTED +++++");
		
		ISupplierService supplierService = new SupplierServiceImpl();
		//REGISTER THE SUPPLIER SERVICE
		serviceRegistration = bundleContext.registerService(ISupplierService.class.getName(), supplierService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("+++++ SPARE PARTS SERVICE STOPPED +++++");
		serviceRegistration.unregister();
	}

}
