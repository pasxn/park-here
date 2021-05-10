/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


import java.util.ArrayList;
import java.util.Scanner;

public class SLIITCarParkManager implements CarParkManager{
	
	// array which stores the data
	private ArrayList<Vehicle> slots = new ArrayList<Vehicle>();
	// To scan object from standard input
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		SLIITCarParkManager carPark = new SLIITCarParkManager();
		// user interaction starts here
		welcomeScreen();
		// Main loop starts here
		
		while (true) {
			
			line();
			System.out.println("Press the labelled key on your keybord\n");
			System.out.println("Enter a vehicle [e]");
			System.out.println("Remove a vehicle [r]");
			System.out.println("Search a vehicle [s]");
			System.out.println("Get the no. of empty slots [n]");
			System.out.println("Get the no. of occupied slots [o]");
			System.out.println("View the vehicle list [p]");
			System.out.println("Quit the program [q]");
			
			line();
			char userInput  = getUserInput();
			switch(userInput) {
			case 'e':
				carPark.vehicleEntered();
				break;
			
			case 's':
				carPark.searchVehicles();
				break;
				
			case 'r':
				System.out.println("\nNo. of occupied slots: " + carPark.vehicleLeft());
				break;
			
			case 'n':
				System.out.println("N0. of empty slots: " + carPark.getNumEmptySlots());
				break;
				
			case 'o':
				System.out.println("No. of occupied slots: " + carPark.getNumOccupiedSlots());
				break;
				
			case 'p':
				carPark.viewDatabase();
				break;
			
			case 'q':
				clearConsole();
				byeBye();
				System.exit(0);
				
			case '~':
				warn();
				break;
				
			default:
				warn();
				break;	
			}
		}
	}
	
	
	
	
	public boolean vehicleEntered() {
		boolean isSuccessful = true;
		try {
			//Checking for available slots
			if(slots.size() < totalVehicleSlots) {
				line();
				System.out.println("Choose the Vehicle class\n");
				System.out.println("Car[c]");
				System.out.println("Van[v]");
				System.out.println("Three Wheeler[t]");
				line();
				
				char vehicleType = getUserInput();
				
				line();
				if (vehicleType == 'c') {
					System.out.println("\nEnter bellow fields\n");
					System.out.print("Licence plate number: ");
					String plateTmp = sc.nextLine();
					System.out.print("Brand: ");
					String brandTmp = sc.nextLine();
					System.out.print("Color: ");
					String colorTmp = sc.nextLine();
					System.out.print("No. of doors: ");
					int nofDoorsTmp = Integer.parseInt(sc.nextLine());
					slots.add(new Car(plateTmp, brandTmp, nofDoorsTmp, colorTmp));
					System.out.println("\nYour entry was recored successfully!\n");
				
				} else if (vehicleType == 'v') {
					System.out.println("\nEnter bellow fields\n");
					System.out.print("Licence plate number: ");
					String plateTmp = sc.nextLine();
					System.out.print("Brand: ");
					String brandTmp = sc.nextLine();
					System.out.println("Passenger of Cargo? (Pasenger(p)/Cargo(c)");
					char input = getUserInput();
					int nofSeatsTmp = 0;
					int cargoCapacityTmp = 0;
					boolean isCargo = true;
					
					if(input=='p') {
						System.out.print("Number of seats: ");
						nofSeatsTmp = Integer.parseInt(sc.nextLine());
						cargoCapacityTmp = 0;
						isCargo = false;
						slots.add(new Van(plateTmp, brandTmp, nofSeatsTmp, cargoCapacityTmp, isCargo));
					}else if(input=='c') {
						System.out.print("Cargo capacity(kg): ");
						cargoCapacityTmp = Integer.parseInt(sc.nextLine());
						nofSeatsTmp = 0;
						isCargo = true;
						slots.add(new Van(plateTmp, brandTmp, nofSeatsTmp, cargoCapacityTmp, isCargo));
					}else warn();
					 
					System.out.println("\nYour entry was recored successfully!\n");
				
				} else if (vehicleType == 't') {
					System.out.println("\nEnter bellow fields\n");
					System.out.print("Licence plate number: ");
					String plateTmp = sc.nextLine();
					System.out.print("Brand: ");
					String brandTmp = sc.nextLine();
					System.out.println("Is this vehicle for hire? (Yes(y)/No(n)");
					char input = getUserInput();
					boolean isHireTmp = false;
					
					if(input=='y') {
						isHireTmp = true;
						slots.add(new ThreeWheel(plateTmp, brandTmp, isHireTmp));
					}
					else if (input=='n') {
						isHireTmp = false;
						slots.add(new ThreeWheel(plateTmp, brandTmp, isHireTmp));
					}
					else warn();
					
					System.out.println("\nYour entry was recored successfully!\n");
				
				} else warn();
				System.out.println("Number of free slots left: " + (totalVehicleSlots - slots.size()) +"\n");
				
			}else {
				line();
				System.out.println("The car park is full. Wait untill someone leaves!");
				isSuccessful = false;
			}
		}catch(Exception e) {}
		
		return isSuccessful;
	}		
	

	public int vehicleLeft() {
		System.out.print("Enter the license plate of the vehicle: ");
		String licenseTmp = sc.nextLine();
		
		for(int i = 0; i<slots.size(); i++) {
			Vehicle tmp = slots.get(i);
			if(tmp.getIDplate().equals(licenseTmp)) {
				System.out.println("\nThe "+tmp.getClass().toString().substring(tmp.getClass().toString().lastIndexOf(" ")+1)+" is leaving the parking lot.\n" );
				System.out.println("Date entered :" + tmp.getDateTime().getDate());
				System.out.println("Time entered :" + tmp.getDateTime().getTime());
				slots.remove(tmp);
			}
		}
		return slots.size();
	}

	public int getNumEmptySlots() {
		return totalVehicleSlots - slots.size();
	}

	public int getNumOccupiedSlots() {
		return slots.size();
	}
	
	public void searchVehicles() {
		System.out.print("Enter the license plate of the vehicle: ");
		String licenseTmp = sc.nextLine();
		System.out.println("");
		
		for(int i = 0; i<slots.size(); i++) {
			if(slots.get(i).getIDplate().equals(licenseTmp)) {
					printDetails(slots.get(i));
					String key =  slots.get(i).getClass().toString();
					if(key.contains("Car")) {
						System.out.println("Color: " + slots.get(i).getColor());
						System.out.println("No. of doors: " + slots.get(i).getnofDoors());
					}else if(key.contains("Van")) {
						if(slots.get(i).getIscargo() == false)
							System.out.println("No. of seats: " + slots.get(i).getNofseats());
						else if(slots.get(i).getIscargo() == true)
							System.out.println("Cargo Capacity: " + slots.get(i).getCargocapacity());
					}else if(key.contains("ThreeWheel")) {
						System.out.println(slots.get(i).isTaxi());
					}
			}else {
				System.out.println("Invalid license plate number! Input again.");
			}
		}
		
	}
	
	
	public void viewDatabase() {
		line();
		for(int i = 0; i<slots.size(); i++) {
			printDetails(slots.get(i));
			System.out.println("");
		}
		if (slots.size() == 0) System.out.println("The car park is empty at the moment!");
	}
	
	
	
	
	//private static methods
	private static void welcomeScreen() {
		System.out.print("\nSLIIT CAR PARK MANAGER");
		System.out.println(" : Version 0.1\n");
		System.out.println("Written by : EN20421380 [Perera R.P.S.]");
	}
	
	private static char getUserInput() {
		System.out.print("Enter your input: ");
		try {
			char input = sc.nextLine().trim().charAt(0);
			return Character.toLowerCase(input);
		
		}catch(Exception e) {
			warn();
			return '~';
		}
		
	}
	
	private static void printDetails(Vehicle tmp) {
		System.out.println("Vehicle type: " + tmp.getClass().toString().substring(tmp.getClass().toString().lastIndexOf(" ")+1));
		System.out.println("Brand: " + tmp.getBrand());
		System.out.println("Date entered: " + tmp.getDateTime().getDate());
		System.out.println("Time entered: " + tmp.getDateTime().getTime());
	}
	
	private static void byeBye() {
		System.out.print("SLIIT CAR PARK MANAGER");
		System.out.println(" : Version 0.1");
		System.out.println("©2021 All rights reserved");
		System.out.println("\n_______Program Terminated_______\n");
	}
	
	private static void line() {
		System.out.println("________________________________________________\n");
	}
	
	private static void warn() {
		System.out.println("\nInvalid Input!");
	}
	
	// a clear using ASCII Escape codes
	//(only works in the linux/macos terminal emulator, should check in cmd before submitting)
	//shows some weird symbols in Eclipse console 
    public static void clearConsole(){
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
    }
}
