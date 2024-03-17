package orderconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import order_service_interface.IOrderService;
import spares_data.SpareItems;
import com.mtit.sparepartsservice.customerproducer.customerService;

public class ServiceActivator implements BundleActivator {

    ServiceReference serviceReference;
    private boolean exit = false;
    Scanner input = new Scanner(System.in);
    private boolean user = true;
    private String name;
    private String pwd;
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("==========ORDER CONSUMER STARTED==========");

        serviceReference = context.getServiceReference(IOrderService.class.getName());
        @SuppressWarnings("unchecked")
        IOrderService orderservice = (IOrderService) context.getService(serviceReference); // INSTANCE OF ORDER SERVICE

        
        while(user) {
        	 System.out.println("\n" + "----------WELCOME TO Logging----------\n");
        	System.out.println("Please insert the name >>");
        	name = input.next();
        	System.out.println("Please insert the password >>");
        	pwd = input.next();
        	
        	if(name.equalsIgnoreCase("sandithya")) {
        		if( pwd.equalsIgnoreCase("123"))
        		{
        			user = false;
        		}else {
        			System.out.println("invalid user name");
        		}
        	}else {
        		System.out.println("invalid user name");
        	}
        }
        
        while (!exit) {
            int option = 4;

            do {
                System.out.println("\n" + "----------WELCOME TO BILLING----------");

                System.out.println("Please select your option for continue >>");
                System.out.println("--Options--");
                System.out.println("(1) Available Spare Item List");
                System.out.println("(2) Create Spare Item Order");
                System.out.println("(3) Exit");

                System.out.println("\n" + "Input selected option >> ");
                option = input.nextInt();

                input.nextLine();
                if (option == 3) { // TO EXIT PROGRAMME
                    exit = true;
                    break;
                }

                if (option != 1 && option != 2 && option != 3) {
                    System.out.println("Please select valid option!!");
                }

            } while (option != 1 && option != 2 && option != 3);

            if (option == 1) { 
                displaySpareItemList(orderservice);
            } else if (option == 2) {  // ORDERINNG VIEW AND PROCESS
                makeSpareItemOrder(orderservice);
            }
        }
    }

    private void displaySpareItemList(IOrderService orderservice) {
        String toHome;
        do {
            List<SpareItems> spareItemList = orderservice.displaySpareItems();

            System.out.println("--------------------------------ORDER ITEM LIST--------------------------------------");
            System.out.println("_______________________________________________________________________________________________________");
            System.out.println("Spare Item ID:" + "\t" + "| Spare Item Name:" + "\t" + "| Quantity:" + "\t" + "| Spare Price:" + "\t" + "| Discount (%):" + "\t" + "| Net Price:  |" + "\t");
            System.out.println("_______________________________________________________________________________________________________\n");
            for (SpareItems tempSpareItem : spareItemList) {

                System.out.println("\t" + tempSpareItem.getSpareId() + "\t      " + tempSpareItem.getSpareName() + "\t             " + tempSpareItem.getQuantity() + "\t             " + tempSpareItem.getSparePrice() + "\t      " + tempSpareItem.getSparediscount() + "\t   " + tempSpareItem.getNetPrice() + "\t" + "\n");

                System.out.println("........................................................................................................");
            }

            System.out.println("\n-----------------------------------------------------------------------------------------");

            System.out.println("press '0' to go home OR press 'any key' to continue >>");

            toHome = input.nextLine();

        } while (!(toHome.equals("0")));
    }

    private void makeSpareItemOrder(IOrderService orderservice) {
        String calculateNetBill;
        int spareItemCount = -1;
        List<SpareItems> orderItems = new ArrayList<>(); // Store ordered items

        do {
            System.out.println("----------WELCOME TO SPARE ITEMS'S ORDERING----------" + "\n");

            System.out.println("Enter the Spare Item Id : ");
            int id = input.nextInt();

            System.out.println("Enter quantity : ");
            int qty = input.nextInt();

            int output = orderservice.generateBill(id, qty); 
            if (output == -1) {
                System.out.println("Please enter valid Spare Item ID!!");
            } else {
                spareItemCount++;
                orderItems.add(orderservice.getSpareItem(id)); // Add the ordered item to the list
                orderItems.get(spareItemCount).setQuantity(qty); // Update the quantity for the ordered item
            }

            input.nextLine();
            System.out.println("Do you want to continue ordering? (yes/no)");
            calculateNetBill = input.nextLine();

        } while (calculateNetBill.equalsIgnoreCase("yes"));

        // Display the ordered items before proceeding to checkout
        System.out.println("\nOrdered Items:");
        for (SpareItems orderedItem : orderItems) {
            System.out.println(orderedItem.getSpareId() + "\t" + orderedItem.getSpareName() + "\t" +
                    orderedItem.getQuantity());
        }

        System.out.println("\nDo you want to checkout? (yes/no)");
        String checkoutDecision = input.nextLine();

        if (checkoutDecision.equalsIgnoreCase("no")) {
            return;
        } else if (checkoutDecision.equalsIgnoreCase("yes")) {
            // Proceed to checkout
            while (true) {
                System.out.println("\n-------------------------------RECEIPT-------------------------------");

                String[][] billDetails = orderservice.displayBillDetails();

                String format = "%-20s";
                System.out.printf(format, "Spare Item ID:");
                System.out.printf(format, "Spare Item Name:");
                System.out.printf(format, "Quantity:");
                System.out.printf(format, "Total:");
                System.out.printf("\n");

                double totalBillAmount = 0;
                for (int i = 0; i <= spareItemCount; i++) {
                    for (int j = 0; j < billDetails[i].length; j++) {
                        System.out.printf(format, billDetails[i][j]);
                    }
                    totalBillAmount += Double.parseDouble(billDetails[i][3]);
                    System.out.println("");
                }

                System.out.println("                                                          ----------");
                System.out.println("Subtotal:                                                   " + totalBillAmount);
                System.out.println("                                                          ----------");
                System.out.println("                                                          ----------");
                System.out.println("--------------------------------------------------------------------------------------");

                System.out.println("Do you want to update the order? (yes/no)");
                String updateOrderDecision = input.nextLine();

                if (updateOrderDecision.equalsIgnoreCase("yes")) {
                    // Update the order
                    if (!updateOrder(orderItems, orderservice)) {
                        continue; // Order not updated, ask again
                    }
                }

                // Place the order
                System.out.println("Do you want to place the order? (yes/no)");
                String placeOrderDecision = input.next();

                if (placeOrderDecision.equalsIgnoreCase("yes")) {
                    // Place the order
                    System.out.println("Order successful!");
                    break;
                } else {
                    System.out.println("Order cancelled.");
                    break;
                }
            }
        } else {
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        }
    }

    private boolean updateOrder(List<SpareItems> orderItems, IOrderService orderservice) {
        // Update the order
        System.out.println("Choose what you want to do:");
        System.out.println("1. Update product quantity");
        System.out.println("2. Update product ID");
        System.out.println("3. Remove item from order");
        System.out.println("4. Add another item to order");
        System.out.println("Enter your choice:");
        int updateChoice = input.nextInt();

        switch (updateChoice) {
            case 1:
                // Update product quantity
                System.out.println("Enter product ID for which you want to update quantity:");
                int productIdQuantity = input.nextInt();
                System.out.println("Enter new quantity:");
                int newQuantity = input.nextInt();
                for (SpareItems orderedItem : orderItems) {
                    if (orderedItem.getSpareId() == productIdQuantity) {
                        orderedItem.setQuantity(newQuantity);
                        break;
                    }
                }
                break;
            case 2:
                // Update product ID
                System.out.println("Enter current product ID:");
                int currentProductId = input.nextInt();
                System.out.println("Enter new product ID:");
                int newProductId = input.nextInt();
                for (SpareItems orderedItem : orderItems) {
                    if (orderedItem.getSpareId() == currentProductId) {
                        // Remove the item with the current product ID
                        orderItems.remove(orderedItem);
                        // Add a new item with the new product ID
                        orderItems.add(orderservice.getSpareItem(newProductId));
                        break;
                    }
                }
                break;
            case 3:
                // Remove item from order
                System.out.println("Enter product ID to remove from order:");
                int productIdToRemove = input.nextInt();
                for (SpareItems orderedItem : orderItems) {
                    if (orderedItem.getSpareId() == productIdToRemove) {
                        orderItems.remove(orderedItem);
                        break;
                    }
                }
                break;
            case 4:
                // Add another item to order
                System.out.println("Enter product ID to add to order:");
                int productIdToAdd = input.nextInt();
                System.out.println("Enter quantity:");
                int quantityToAdd = input.nextInt();
                orderItems.add(orderservice.getSpareItem(productIdToAdd)); 
                orderItems.get(orderItems.size() - 1).setQuantity(quantityToAdd);
                break;
            default:
                System.out.println("Invalid choice!");
                return false; // Order not updated
        }

        // Display updated order
        System.out.println("\nUpdated Order:");
        double subtotal = 0;
        String format = "%-20s%-20s%-20s%-20s%-20s%n";
        System.out.printf(format, "Spare Item ID", "Spare Item Name", "Quantity", "Total", "Subtotal");
        for (SpareItems orderedItem : orderItems) {
            double total = orderedItem.getSparePrice() * orderedItem.getQuantity();
            System.out.printf(format, orderedItem.getSpareId(), orderedItem.getSpareName(), orderedItem.getQuantity(), total, "");
            subtotal += total;
        }
        System.out.printf("%-80s%-20s%n", "", "Total: " + subtotal);
        return true; // Order updated
    }


    private void placeOrder(List<SpareItems> orderItems) {
        System.out.println("Do you want to place the order? (yes/no)");
        String placeOrderDecision = input.next();

        if (placeOrderDecision.equalsIgnoreCase("yes")) {
            // Place the order
            System.out.println("Order successful!");
        } else {
            System.out.println("Order cancelled.");
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("==========ORDER STOPPED==========");
        bundleContext.ungetService(serviceReference);
    }
}