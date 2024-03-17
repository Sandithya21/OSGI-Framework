package deliveryconsumer;

import java.util.*;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import delivery_data.DeliveryItem;
import delivery_data.DeliveryPerson;
import delivery_service_interface.IDeliveryService;

public class ServiceActivator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	boolean exit = false;

	@SuppressWarnings("unused")
	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("########### Delivery Person Started!!!!1 ###########");
		
		serviceReference = bundleContext.getServiceReference(IDeliveryService.class.getName());
		@SuppressWarnings("unchecked")
		IDeliveryService deliveryService = (IDeliveryService) bundleContext.getService(serviceReference);
		
		do {
			int option = 7;
			
			do {
				System.out.println("\n\n" + "~~~~~ WELCOME TO Delivery service ~~~~~");
				
				System.out.println(".......................................");
				System.out.println("<<<<<<<<<<<<<<< options >>>>>>>>>>>>>>>");
				System.out.println(".......................................\n");
				
				System.out.println("(1) Add new Delivery Person.");
				System.out.println("(2) Update an exsisting Delivery Person.");
				System.out.println("(3) Remove an exsisting Delivery Person.");
				System.out.println("(4) List All the Delivery Persons.");
				System.out.println("(5) Search delivery persons by name.");
				System.out.println("(6) Assign an item for a Delivery person");
				System.out.println("(7) Exit");
				
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
			        System.out.println("\n\n<<<<<<<<<<< Adding new Delivery person >>>>>>>>>>>\n");
			        
			        try {
			            System.out.println("Delivery person Name : ");
			            String personName = input.nextLine();
			        
			            System.out.println("salary : ");
			            double salary = input.nextDouble();
			        
			            System.out.println("For additionl distance travled price: ");
			            double additionalPrice= input.nextDouble();
			            
			            System.out.println("Age : ");
			            int age = input.nextInt();
			        
			            input.nextLine(); // Consume the leftover newline
			            
			            System.out.println("Delivery Item : ");
			            String deliveryItem = input.nextLine();
			            System.out.println("Branch : ");
			            String branch = input.nextLine();
			            
			            System.out.println("Location : ");
			            String address = input.nextLine();
			        
			            int output = deliveryService.addDeliveryPerson(personName, salary, additionalPrice, age,deliveryItem, branch, address);
			            String message = (output == 1) ? "\n!!Successfully added the Delivery Person!!" : "An error occurred. Please ensure the Person name is unique and all inputs are valid.";
			            System.out.println(message);
			            System.out.println("\n\npress 'Exit' to go back to home OR press 'any key' to continue >>");
			            toHome = input.nextLine();
			            }catch(Exception e) {
			                System.out.println("...Invalid Inputs...");
			                System.out.println(e);
			            }
			    }while(!(toHome.equals("Exit")));
			}

				
			
			
	else if(option == 2) { // UPDATING PROCESS
	    do {
	        System.out.println("\n\n<<<<<<<<<<< Updating delivery Person >>>>>>>>>>>\n");
	        try {
	        	System.out.println("Delivery person Name : ");
	            String personName = input.nextLine();
	        
	            System.out.println("salary : ");
	            double salary = input.nextDouble();
	        
	            System.out.println("For additionl distance travled price: ");
	            double additionalPrice= input.nextDouble();
	            
	            System.out.println("Age : ");
	            int age = input.nextInt();
	        
	            input.nextLine(); // Consume the leftover newline
	            
	            System.out.println("Delivery Item : ");
	            String deliveryItem = input.nextLine();
	            
	            System.out.println("Branch : ");
	            String branch = input.nextLine();
	            
	            System.out.println("Location : ");
	            String address = input.nextLine();
	            
	            int output = deliveryService.updateDeliveryPerson(personName, salary, additionalPrice, age,deliveryItem, branch, address);
	            String message = (output == 1) ? "\n!!Successfully updated the Delivery Person Details!!" : "Please enter valid details!!";
	            System.out.println(message);
	            
	            System.out.println("\n\nPress 'Exit' to go back to home OR press 'any key' to continue >>");
	            toHome = input.nextLine();
	        } catch(Exception e) {
	            System.out.println("...Invalid Inputs...");
	            System.out.println(e.getMessage());
	        }
	    } while(!(toHome.equals("Exit")));
	}

			
			
	else if(option == 3) { // REMOVING PROCESS

	    do {
	        System.out.println("\n\n<<<<<<<<<<<<< Remove delivery Person >>>>>>>>>>>>>\n");
	        System.out.println("Enter the Delivery Person name : ");
	        String person = input.nextLine();
	        
	        int output = deliveryService.removeDeliveryPerson(person); // Adjusted method call
	        String message = (output == 1) ? "\n!!Successfully Removed the Delivery Person!!" : "Please enter a valid name!!";
	        System.out.println(message);
	        
	        System.out.println("\n\nPress 'Exit' to go back to home OR press 'any key' to continue >>");
	        toHome = input.nextLine();
	        
	    } while(!(toHome.equals("Exit")));
	    
	}

			
			
	else if(option == 4) { // ITEM LIST DISPLAY PROCESS

	    do {
	        List<DeliveryPerson> deliveryItemList = deliveryService.listDeliveryItems();

	        System.out.println("--------------------------------------DELIVERY ITEM LIST--------------------------------------\n");
	        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");
	        System.out.println(" Person ID:"+"\t" +"| Person Name:"+"\t"+ "| Salary:"+"\t"+ "| Additional price"+"\t" + "| Age:"+"\t" +"\t"+"| Delivery Item "+"| Branch:"+"\t"+ "| Address:  |"+"\t");
	        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________\n");
	        for(DeliveryPerson tempItem : deliveryItemList) {

	            // Assuming you have getter methods in your DeliveryItem class to fetch these details
	            System.out.println("\t"+tempItem.getPersonId()+"\t      "+tempItem.getPerson()+"\t     "+tempItem.getSalary()+"\t    \t  "+tempItem.getAdditionalAmount()+"\t"    + "\t  "+tempItem.getAge()+"\t   "+"\t   "+tempItem.getDeliveryItem()+"\t        "+tempItem.getBranch()+"\t         "+tempItem.getAddress()+"\t   ");

	            System.out.println("........................................................................................................");
	        }

	        System.out.println("\n-----------------------------------------------------------------------------------------");

	        System.out.println("\nPress 'Exit' to go back to home OR press 'any key' to continue >>");
	        toHome = input.nextLine();

	    }while(!(toHome.equals("Exit")));

	}

			
	else if(option == 5) { // ITEM SEARCHING PROCESS

	    do {
	        System.out.println("\nEnter the Delivery Item name : ");
	        String Person = input.nextLine();

	        // Assuming searchDeliveryItem returns an int (e.g., 1 for found, 0 for not found)
	        int searchResult = deliveryService.removeDeliveryPerson(Person);
	        String message = (searchResult == 1) ? "Delivery Person found!!" : "Delivery Person not found!!";
	        System.out.println(message);

	        System.out.println("\nPress 'Exit' to go back to home OR press 'any key' to continue >>");
	        toHome = input.nextLine();

	    }while(!(toHome.equals("Exit")));

	}

	else if(option==6) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		    // Assume there's code here to define and handle various options
		   
		        // Prompt for and read the DeliveryItem details from the user
		        System.out.println("Enter item ID:");
		        int itemId = scan.nextInt(); // Reading item ID
		        
		        scan.nextLine(); // Consume the leftover newline
		        
		        System.out.println("Enter description:");
		        String description = scan.nextLine(); // Reading description
		        
		        System.out.println("Enter weight:");
		        double weight = scan.nextDouble(); // Reading weight
		        
		        scan.nextLine(); // Consume the leftover newline
		        
		        System.out.println("Enter status:");
		        String status = scan.nextLine(); // Reading status

		        // Assuming DeliveryItem is a class you've defined, and it has a constructor as provided by you
		        DeliveryItem newItem = new DeliveryItem(itemId, description, weight, status);
		        
		        // At this point, you've created a new DeliveryItem. You can add it to a collection, database, or use as needed
		        System.out.println("New delivery item added successfully!");
		        
		        // Optionally, display the entered information or proceed with further processing
		    }
		    
		    // Assume there's more code here to handle other options or to close resources
		

			
			else if(option == 7) { //EXIT PROCESS
				return;
			}
			
//			else if (option == 7) {
//			    Scanner scanner = new Scanner(System.in);
//
//			    // Prompt for and get the delivery person's identifier (e.g., name or ID)
//			    System.out.println("Enter the delivery person's identifier:");
//			    String personIdentifier = scanner.nextLine();
//
//			    // Find the delivery person
//			    DeliveryPerson person = null;
//			    for (DeliveryPerson dp : DeliveryStore.deliveryList) {
//			        if (dp.getIdentifier().equalsIgnoreCase(personIdentifier)) { // Assuming getIdentifier() method exists
//			            person = dp;
//			            break;
//			        }
//			    }
//
//			    if (person == null) {
//			        System.out.println("Delivery person not found.");
//			        return; // Or continue, based on your flow
//			    }
//
//			    // Prompt for and get the delivery item's identifier
//			    System.out.println("Enter the delivery item's identifier:");
//			    String itemIdentifier = scanner.nextLine();
//
//			    // Find the delivery item. This assumes you have a list or collection of delivery items somewhere.
//			    DeliveryItem item = null;
//			    for (DeliveryItemStore di : DeliveryItemStore.deliveryItemList) { // Assuming such a store exists
//			        if (di.getIdentifier().equalsIgnoreCase(itemIdentifier)) { // Assuming getIdentifier() method exists
//			            item = di;
//			            break;
//			        }
//			    }
//
//			    if (item == null) {
//			        System.out.println("Delivery item not found.");
//			        return; // Or continue, based on your flow
//			    }
//
//			    // Assign the item to the person
//			   // boolean assignmentSuccess = person.assignItem(item); // Assuming assignItem() method exists in DeliveryPerson
//
////			    if (assignmentSuccess) {
////			        System.out.println("Item assigned successfully.");
////			    } else {
////			        System.out.println("Item could not be assigned.");
////			    }
//			}
			
		
		}while(!exit);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========SPARE SUPPLIER STOPPED==========");
		bundleContext.ungetService(serviceReference);
	}

}
