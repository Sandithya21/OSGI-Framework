package order_service_impl;


import java.util.List;
import spares_data.SpareItems;
import order_service_interface.IOrderService;
import spares_store.SpareStore;

public class OrderServiceImpl implements IOrderService{
	
	private List<SpareItems> SpareItemList = SpareStore.spareList; //Spare ITEM LIST DETAILS
	private double bill; //STORE BILL VALUE
	private String[][] billDetails = new String[10][4]; //TO STORE TAKEN Spare ITEMS'S DETAILS (ASSUPTION : ONLY 10 DIFFERET ITEMS ALLOWED FOR 1 ORDER)
	private int count = -1; //STORE Spare ITEMS COUNT (STARTING FROM 0)

	@Override
	public List<SpareItems> displaySpareItems() {
		// TODO Auto-generated method stub
		return SpareStore.spareList;
	}

	@Override
	public SpareItems getSpareItem(int id) {
		// TODO Auto-generated method stub
		// Get a SpareItem by ID
				for(SpareItems item : SpareItemList) {
					if(item.getSpareId() == id) {
						return item;
					}
				}
				return null; // Return null if SpareItem with the given ID is not found
			}

	@Override
	public int generateBill(int iId, int qty) {
		// TODO Auto-generated method stub
		boolean valid = false;
		SpareItems currentSpareItem = null;
		
		for(SpareItems tempSpareItem : SpareItemList) {
			if(iId == tempSpareItem.getSpareId()) {
				currentSpareItem = tempSpareItem;
				valid = true;
				count ++;
				break;
			}
		}
		if(valid) {
			this.bill = this.bill + (currentSpareItem.getNetPrice() * qty);
			
			billDetails[count][0] = Integer.toString(iId);
			billDetails[count][1] = currentSpareItem.getSpareName();
			
			billDetails[count][2] = Integer.toString(qty);
			billDetails[count][3] = Double.toString((currentSpareItem.getNetPrice() * qty));
			
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public double displayTotalBillAmount() {
		// TODO Auto-generated method stub
		double totalBill = this.bill;
		newBill();
		return totalBill;
	}

	@Override
	public String[][] displayBillDetails() {
		// TODO Auto-generated method stub
		return billDetails;
	}
	
	public void newBill() {
		this.bill = 0;
		this.count = -1;
	}

}
