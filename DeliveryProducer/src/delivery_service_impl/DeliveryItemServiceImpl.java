package delivery_service_impl;

//
//import java.util.List;
//
//
//import spares_data.DeliveryItem;
//import spares_data.DeliveryPerson;
//
//import spares_store.DeliveryStore;
//import supplier_service_interface.IDeliveryServiceInterface;
//
//public class DeliveryItemServiceImpl implements IDeliveryServiceInterface {
//
//	@Override
//	public int addDeliveryItem(int itemId, String description, double weight, String status) {
//		DeliveryItem deliveryItems=new DeliveryItem(itemId,description,weight,status);
//		DeliveryStore.deliveryItemList.add(deliveryItems);
//		return 1;
//	}
//
//	@Override
//	public int updateDeliveryPersonItem(int itemId, String description, double weight, String status) {
//	    DeliveryItem itemToBeUpdated = null;
//	    boolean found = false;
//
//	    for (DeliveryItem tempItem : DeliveryStore.deliveryItemList) {
//	        if (tempItem.getItemId() == itemId) { // Corrected this line
//	            itemToBeUpdated = tempItem;
//	            found = true;
//	            break;
//	        }
//	    }
//
//	    if (found) {
//	        itemToBeUpdated.setDescription(description);
//	        itemToBeUpdated.setWeight(weight);
//	        itemToBeUpdated.setStatus(status);
//	        return 1; // Indicates success
//	    } else {
//	        return -1; // Indicates failure (item not found)
//	    }
//	}
//
//
//	@Override
//	public int removeDeliveryItem(String itemName) {
//	    boolean found = false;
//	    int indexToRemove = -1;
//	    
//	    // Iterate through the deliveryItemList to find the item to remove
//	    for (int i = 0; i < DeliveryStore.deliveryItemList.size(); i++) {
//	        DeliveryItem item = DeliveryStore.deliveryItemList.get(i);
//	        if (item.getDescription().equalsIgnoreCase(itemName)) {
//	            indexToRemove = i;
//	            found = true;
//	            break;
//	        }
//	    }
//	    
//	    // If an item was found, remove it
//	    if (found) {
//	        DeliveryStore.deliveryItemList.remove(indexToRemove);
//	        return 1; // Indicates success
//	    } else {
//	        return -1; // Indicates that no item with the given name was found
//	    }
//	}
//
//
//	@Override
//	public List<DeliveryItem> listDeliveryItems() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}

