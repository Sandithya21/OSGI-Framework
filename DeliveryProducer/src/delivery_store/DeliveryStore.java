package delivery_store;

import java.util.ArrayList;



import java.util.List;

import delivery_data.DeliveryPerson;


public class DeliveryStore {
    // STORE SHARED DATA AMONG PRODUCER AND CONSUMER
    public static List<DeliveryPerson> deliveryList = new ArrayList<DeliveryPerson>();
//    public static List<DeliveryItem> deliveryItemList = new ArrayList<DeliveryItem>();
}
