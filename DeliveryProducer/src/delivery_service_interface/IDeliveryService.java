package delivery_service_interface;

import java.util.List;

import delivery_data.DeliveryPerson;

public interface IDeliveryService {

    // Add a new delivery item to the service list
    int addDeliveryPerson(String Person, double salary, double additionalAmount, int age,String deliveryItem, String address,String branch);

    // Update details of an existing delivery item
    int updateDeliveryPerson(String Person, double salary, double additionalAmount, int age,String deliveryItem, String branch, String address);

    // Remove a delivery item from the list by name
    int removeDeliveryPerson(String itemName);

    // Search for a delivery item by name
//int searchDeliveryPerson(String itemName);

    // Return the list of delivery items
    List<DeliveryPerson> listDeliveryItems();


}

