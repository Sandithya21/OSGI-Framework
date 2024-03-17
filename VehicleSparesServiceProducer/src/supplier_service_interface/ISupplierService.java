package supplier_service_interface;

import java.util.List;

import spares_data.SpareItems;

public interface ISupplierService {

	public int addItems(String itemName, double itemPrice, double itemDiscount, int quantity); //ADD NEW ITEM TO SERVICE LIST
	public int updateItems(String updateItemName, double updateItemPrice, double updateItemDiscount, int quantity); //UPDATE ITEM DETAILS
	public int removeItems(String itemName); //REMOVE ITEM FROM LIST BY NAME
	public int searchItems(String itemName); //SEARCH ITEM BY NAME
	
	public List<SpareItems> listItems(); //RETUEN ITEM LIST
	
}
