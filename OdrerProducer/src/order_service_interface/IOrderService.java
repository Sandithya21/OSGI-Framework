package order_service_interface;

import java.util.List;
import spares_data.SpareItems;

public interface IOrderService {
    public List<SpareItems> displaySpareItems(); //RETURN THE SPARE ITEM LIST WITH SPARE ITEM DETAILS
    public int generateBill(int iId, int qty); //CALCULATES BILL
    public double displayTotalBillAmount(); //DISPLAY TOTAL AMOUNT
    public String[][] displayBillDetails(); //DISPLAY GIVEN SPARE ITEM LIST WITH DETAILS
    public SpareItems getSpareItem(int id); // Method to get a SpareItem by ID
}
