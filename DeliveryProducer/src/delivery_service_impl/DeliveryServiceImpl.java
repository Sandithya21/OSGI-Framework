package delivery_service_impl;

import java.util.List;

import delivery_data.DeliveryPerson;
import delivery_service_interface.IDeliveryService;
import delivery_store.DeliveryStore;


public class DeliveryServiceImpl implements IDeliveryService {

    public synchronized int addDeliveryPerson(String Person, double salary, double additionalAmount, int age,String deliveryItem,String branch, String address) {
        // Assuming DeliveryItem has a constructor that matches these parameters
        DeliveryPerson newDeliveryItem = new DeliveryPerson(DeliveryStore.deliveryList.size()+1,Person,salary,additionalAmount,age,deliveryItem, branch,address);
        DeliveryStore.deliveryList.add(newDeliveryItem);
        return 1;
    }

    @Override
    public synchronized int updateDeliveryPerson(String Person, double salary, double additionalAmount, int age,String deliveryItem, String branch, String address) {
        DeliveryPerson itemToBeUpdated = null;
        boolean found = false;
        
        for(DeliveryPerson tempItem : DeliveryStore.deliveryList) {
            if(tempItem.getPerson().equalsIgnoreCase(Person)) {
                itemToBeUpdated = tempItem;
                found = true;
                break;
            }
        }
        if(found) {
            // Assuming setters for all the fields exist in DeliveryItem
            itemToBeUpdated.setPerson(Person);
            itemToBeUpdated.setSalary(salary);
            itemToBeUpdated.setAdditionalAmount(additionalAmount);
            itemToBeUpdated.setAge(age);
            itemToBeUpdated.setDeliveryItem(deliveryItem);
            itemToBeUpdated.setBranch(branch);
            itemToBeUpdated.setAddress(address);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int removeDeliveryPerson(String person) {
        boolean found = false;
        int index = -1;
        
        for(int i = 0; i < DeliveryStore.deliveryList.size(); i++) {
            if(DeliveryStore.deliveryList.get(i).getPerson().equalsIgnoreCase(person)) {
                index = i;
                found = true;
                break;
            }
        }
        if(found) {
            DeliveryStore.deliveryList.remove(index);
            return 1;
        } else {
            return -1;
        }
    }

//    @Override
//    public int searchDeliveryPerson(String person) {
//        for(DeliveryPerson tempItem : DeliveryPerson.deliveryList) {
//            if(tempItem.getPerson().equalsIgnoreCase(person)) {
//                return 1; // Item found
//            }
//        }
//        return -1; // Item not found
//    }

    @Override
    public List<DeliveryPerson> listDeliveryItems() {
        return DeliveryStore.deliveryList;
    }




	

	
//	public int addDeliveryPerson(String Person, double salary, double additionalAmount, int age, String branch,
//			String address) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

    // Implementing the additional method based on the provided signature
    
}

