package sparepartssupplierconsumer;

import java.util.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import spares_data.SpareItems;
import supplier_service_interface.ISupplierService;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	boolean exit = false;

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("########### SUPPLIER STARTED ###########");
		
		serviceReference = bundleContext.getServiceReference(ISupplierService.class.getName());
		@SuppressWarnings("unchecked")
		ISupplierService supplierService = (ISupplierService) bundleContext.getService(serviceReference);
		
		do {
			int option = 7;
			
			do {
				System.out.println("\n\n" + "~~~~~ WELCOME TO SUPPLIER SERVICE ~~~~~");
				
				System.out.println(".......................................");
				System.out.println("<<<<<<<<<<<<<<< options >>>>>>>>>>>>>>>");
				System.out.println(".......................................\n");
				
				System.out.println("(1) Add new Spare Item.");
				System.out.println("(2) Update an exsisting Spare Item.");
				System.out.println("(3) Delete an exsisting Spare Item.");
				System.out.println("(4) List Spare Items.");
				System.out.println("(5) Search Spare Item by name.");
				System.out.println("(6) Exit");
				
				System.out.println("\n" + "Please select any option to continue >>");
				option = input.nextInt();
				
				input.nextLine();
				
				if(option == 6) {
					exit = true;
				}
				
				if(option !=1 && option !=2 && option !=3 && option !=4 && option !=5 && option !=6) {
					System.out.println("Please enter valid option!!");
				}
			
			}while(option !=1 && option !=2 && option !=3 && option !=4 && option !=5 && option !=6);
			
			String toHome = null;
			
			if(option == 1) { //ADDING PROCESS
				
				do {
					System.out.println("\n\n<<<<<<<<<<< Adding new items >>>>>>>>>>>\n");
					
					try {
						System.out.println("Spare Item Name : ");
						String serviceName = input.nextLine();
					
						System.out.println("Spare Item Price : ");
						double servicePrice = input.nextDouble();
					
						System.out.println("Discount : ");
						double serviceDiscount = input.nextDouble();
						
						System.out.println("Qantity : ");
						int serviceQuantity = input.nextInt();
					
						input.nextLine();
					
						int output = supplierService.addItems(serviceName, servicePrice, serviceDiscount,serviceQuantity);
						String message = (output == 1) ? "\n!!Successfully added the Spare Item!!" : "Please enter valid name!!";
						System.out.println(message);
						System.out.println("\n\npress '0' to go back to home OR press 'any key' to continue >>");
						toHome = input.nextLine();
						}catch(Exception e) {
							System.out.println("...Invalid Inputs...");
							System.out.println(e);
						}
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 2) { //UPDATING PROCESS
				
				do {
					System.out.println("\n\n<<<<<<<<<<< Update new items >>>>>>>>>>>\n");
					try{
						System.out.println("Spare Item Name : ");
						String updateServiceName = input.nextLine();
						
						System.out.println("Spare Item Price : ");
						double updateServicePrice = input.nextDouble();
						
						System.out.println("Discount : ");
						double updateServiceDiscount = input.nextDouble();
						
						System.out.println("Qantity : ");
						int updatedServiceQuantity = input.nextInt();
						
						input.nextLine();
						
						int output = supplierService.updateItems(updateServiceName, updateServicePrice, updateServiceDiscount, updatedServiceQuantity);
						String message = (output == 1) ? "\n!!Successfully updated the Spare Item!!" : "Please enter valid name!!";
						System.out.println(message);
						
						System.out.println("\n\npress '0' to go back to home OR press 'any key' to continue >>");
						toHome = input.nextLine();
					}catch(Exception e) {
						System.out.println("...Invalid Inputs...");
						System.out.println(e);
					}
						
				}while(!(toHome.equals("0")));
			}
			
			
			else if(option == 3) { //REMOVING PROCESS
				
				do {
					System.out.println("\n\n<<<<<<<<<<<<< Delete items >>>>>>>>>>>>>\n");
					System.out.println("Enter the Spare Item name : ");
					String serviceName = input.nextLine();
					
					int output = supplierService.removeItems(serviceName);
					String message = (output == 1) ? "\n!!Successfully deleted the Spare Item!!" : "Please enter valid name!!";
					System.out.println(message);
					
					System.out.println("\n\npress '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 4) { //ITEM LIST DISPLAY PROCESS
				
				do {
					List<SpareItems> SpareItemList = supplierService.listItems();
					
					System.out.println("--------------------------------------SPARE ITEM LIST--------------------------------------\n");
					System.out.println("_______________________________________________________________________________________________________");
					System.out.println("Spare Item ID:"+"\t" +"| Spare Item Name:"+"\t"+ "| Quantity:"+"\t"+ "| Spare Price:"+"\t" + "| Discount (%):"+"\t" + "| Net Price:  |"+"\t");
					System.out.println("_______________________________________________________________________________________________________\n");
					for(SpareItems tempSpareItem : SpareItemList) {
						
						System.out.println("\t"+tempSpareItem.getSpareId()+"\t      "+tempSpareItem.getSpareName()+"\t             "+tempSpareItem.getQuantity()+"\t             "+tempSpareItem.getSparePrice()+"\t      "+tempSpareItem.getSparediscount()+"\t   "+tempSpareItem.getNetPrice()+"\t"+"\n");

						System.out.println("........................................................................................................");
					}
					
					System.out.println("\n-----------------------------------------------------------------------------------------");
					
					System.out.println("\npress '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 5) { //ITEM SEARCHINGG PROCESS
				
				do {
					System.out.println("Enter the Spare Item name : ");
					String serviceName = input.nextLine();
					
					int output = supplierService.searchItems(serviceName);
					String message = (output == 1) ? serviceName + " Spare Item found!!" : "Spare Item not found!!";
					System.out.println(message);
					
					System.out.println("\npress '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 6) { //EXIT PROCESS
				return;
			}
			
		
		}while(!exit);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========SPARE SUPPLIER STOPPED==========");
		bundleContext.ungetService(serviceReference);
	}

}
