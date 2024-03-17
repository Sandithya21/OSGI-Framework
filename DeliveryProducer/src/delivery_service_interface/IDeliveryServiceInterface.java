package delivery_service_interface;

import java.util.List;

import delivery_data.DeliveryItem;


public interface IDeliveryServiceInterface {
	 int addDeliveryItem(int itemId, String description, double weight, String status);

	    // Update details of an existing delivery item
	    int updateDeliveryPersonItem(int itemId, String description, double weight, String status);
	    // Remove a delivery item from the list by name
	    int removeDeliveryItem(String itemName);

	    // Search for a delivery item by name
//	    int searchDeliveryPerson(String itemName);

	    // Return the list of delivery items
	    List<DeliveryItem> listDeliveryItems();
	

}
