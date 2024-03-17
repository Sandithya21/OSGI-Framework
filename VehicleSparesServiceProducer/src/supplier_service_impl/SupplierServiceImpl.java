package supplier_service_impl;

import java.util.List;
import spares_store.SpareStore;
import spares_data.SpareItems;
import supplier_service_interface.ISupplierService;

public class SupplierServiceImpl implements ISupplierService{

	
	@Override
	public synchronized int addItems(String itemName, double itemPrice, double itemDiscount, int Quantity) {
		SpareItems newItems = new SpareItems(SpareStore.spareList.size() + 1, itemName, itemPrice, itemDiscount, Quantity);
		SpareStore.spareList.add(newItems);
		
		return 1;
	}

	
	@Override
	public synchronized int updateItems(String updateItemName, double updateItemPrice, double updateItemDiscount, int updatedQuantity) {
		SpareItems itemToBeUpdate = null;
		boolean invalid = true;
		int count = -1;
		
		for(SpareItems tempItem : SpareStore.spareList) {
			count ++;
			
			if(tempItem.getSpareName().equalsIgnoreCase(updateItemName)) {
				itemToBeUpdate = tempItem;
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			itemToBeUpdate.setSpareName(updateItemName);
			itemToBeUpdate.setSparePrice(updateItemPrice);
			itemToBeUpdate.setSparediscount(updateItemDiscount);
			itemToBeUpdate.setQuantity(updatedQuantity);
			itemToBeUpdate.calculateNetPrice();
			
			SpareStore.spareList.set(count, itemToBeUpdate);
			return 1;
		}
		else {
			return -1;
		}
	}

	
	@Override
	public int removeItems(String itemName) {
		boolean invalid = true;
		int count = -1;
		
		for(SpareItems tempItem : SpareStore.spareList) {
			count ++;
			if(tempItem.getSpareName().equalsIgnoreCase(itemName)) {
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			SpareStore.spareList.remove(count);
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public int searchItems(String itemName) {

		boolean valid = false;
		
		for(SpareItems tempItem : SpareStore.spareList) {
			if(tempItem.getSpareName().equalsIgnoreCase(itemName)) {
				valid = true;
				break;
			}
		}
		if(valid) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public List<SpareItems> listItems() {
		// TODO Auto-generated method stub
		return SpareStore.spareList;
	}

	
}
