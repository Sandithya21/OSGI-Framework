package deliveryproducer;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import delivery_service_impl.DeliveryServiceImpl;
import delivery_service_interface.IDeliveryService;

public class ServiceActivator implements BundleActivator {

    @SuppressWarnings("rawtypes")
	ServiceRegistration serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("+++++ DELIVERY SERVICE STARTED +++++");
        
        IDeliveryService deliveryService = new DeliveryServiceImpl();
//        IDeliveryServiceInterface deliveryInterface= new DeliveryItemServiceImpl();  
        // Register the delivery service
        serviceRegistration = bundleContext.registerService(IDeliveryService.class.getName(), deliveryService, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("+++++ DELIVERY SERVICE STOPPED +++++");
        serviceRegistration.unregister();
    }
}
