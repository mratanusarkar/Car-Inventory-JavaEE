package com.bosch.learn;
import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {
	static int maxSize;
	static int currentSize = -1; // no car in DB (array is the DB here for now)
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		// ArrayList<Car> CarList=new ArrayList<Car>(); 
		/* using an Arraylist is the best idea!
		 * but you had been asked to use Array
		 * pathetic man!
		 */
		
		System.out.print("Enter the maximum number of cars that this application can hold into it's memory: ");
		maxSize = sc.nextInt();
		Car arr[] = new  Car[maxSize];
		currentSize = -1; // no car in DB (array is the DB here for now)
		int choice;
		
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("Welcome to Car Inventory Managment!");
			System.out.println("--------------------------------------------");
			System.out.println("");
			System.out.println("What would you like to do ?");
			System.out.println("");
			System.out.println("1. add a new car");
			System.out.println("2. modify the details of a particular car");
			System.out.println("3. search for a particular car in the catalog");
			System.out.println("4. list all the cars in the catalog");
			System.out.println("5. delete a car from the catalog");
			System.out.println("6. Quit");
			System.out.println("");
			System.out.println("--------------------------------------------");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("--------------------------------------------");
			
			switch(choice) {
			case 1:
				arr = addCar(arr);
			break;
			case 2:
				arr = modifyCar(arr);
			break;
			case 3:
				searchCar(arr);
				break;
			case 4:
				listAll(arr);
			break;
			case 5:
				arr = deleteCar(arr);
			break;
			case 6:
				System.out.println("Thank You for using car inventory services");
				sc.close();
				System.exit(0);
			break;
			default:
				System.out.println("You entered an invalid choice! Try again!");
				System.err.println("user entered case doesn't match any case in the code");
			}
		}
	}

	private static Car[] deleteCar(Car arr[]) {
		if(currentSize == -1) {
			System.out.println("Nothing to delete! The DB is empty!!");
			return arr;
		}
		
		System.out.println("Enter the name of the car you want to delete:");
		String name = sc.nextLine();
		
		for(int i=0; i<=currentSize; i++) {
			if(arr[i].name == name) {
				currentSize--;
				for (int j=i; j<currentSize; j++) {
	                arr[j] = arr[j+1];
				}
				System.out.println("Successfully deleted!");
				return arr;
			}
		}
		System.out.println("Name of that car doesn't exist, hence deletion was unsuccessful!");
		return arr;
		
	}

	private static void listAll(Car arr[]) {
		if(currentSize == -1) {
			System.out.println("The DB is empty!! Nothing to display!!");
			return;
		}
		
		System.out.println("Listing out all the car names in the DB");
		System.out.println();
		for(int i=0; i<=currentSize; i++) {
			System.out.println(i+".\t"+arr[i].name);
		}
		System.out.println();
		
		System.out.println("Do you want to see the list with their full details? (y/n)");
		String str = sc.next();
		if(str.equalsIgnoreCase("y")) {
			System.out.println("Listing out all the car details in the DB");
			System.out.println();
			for(int i=0; i<=currentSize; i++) {
				System.out.println(i+".\t"+arr[i].name);
				System.out.println("\t"+"Car Make:\t"+arr[i].getMake());
				System.out.println("\t"+"Model:\t"+arr[i].getModel());
				System.out.println("\t"+"Year:\t"+arr[i].getYear());
				System.out.println("\t"+"Sales Price:\t"+arr[i].getSalePrice());
				System.out.println();
			}
			System.out.println();
		}
		return;
	}

	private static void searchCar(Car arr[]) {
		if(currentSize == -1) {
			System.out.println("The DB is empty!! Nothing to search LoL!!");
			return;
		}
		System.out.print("Enter the name of the car that you want to search for: ");
		String name = sc.nextLine();
		
		for(int i=0; i<=currentSize; i++) {
			if(arr[i].name == name) {
				System.out.println("Car Found in DB!");
				System.out.println(i+".\t"+arr[i].name);
				System.out.println("\t"+"Car Make:\t"+arr[i].getMake());
				System.out.println("\t"+"Model:\t"+arr[i].getModel());
				System.out.println("\t"+"Year:\t"+arr[i].getYear());
				System.out.println("\t"+"Sales Price:\t"+arr[i].getSalePrice());
				System.out.println();
				return;
			}
		}
		System.out.println("Sorry! that car doesn't exisis in our DB");
		return;
	}

	private static Car[] modifyCar(Car arr[]) {
		if(currentSize == -1) {
			System.out.println("The DB is empty!! Enter some car data first to modify");
			return arr;
		}
		System.out.print("Enter the name of the car that you want to modify: ");
		String name = sc.nextLine();
		System.out.print("Enter new data for the car and enter nothing and hit enter to keep the old data...");
		for(int i=0; i<=currentSize; i++) {
			if(arr[i].name == name) {
				System.out.println("New car make: ");
				String make = sc.nextLine();
				make.trim();
				if(!(make==null || make.isEmpty())) {
					arr[i].setMake(make);
				}
					
				System.out.println("New car model: ");
				String model = sc.nextLine();
				model.trim();
				if(!(model==null || model.isEmpty())) {
					arr[i].setModel(model);
				}
				
				System.out.println("New car year: ");
				int year = sc.nextInt();
				if(year >= 1900 && year <= 2020) {
					arr[i].setYear(year);
				}
				else {
					System.out.println("Invalid year entry");
				}
				
				System.out.println("New car price: ");
				double price = sc.nextDouble();
				if(price > 0) {
					arr[i].setYear(year);
				}
				
				return arr;				
			}
		}
		return arr;
	}

	private static Car[] addCar(Car arr[]) {
		if(currentSize > maxSize) {
			System.out.println("Sorry! our DB is full!");
			System.out.println("Can't add more cars... Contact the admin for help!");
			return arr;
		}
		currentSize++;
		
		System.out.println("Enter your car name: ");
		String name = sc.nextLine();
		System.out.println("Enter your car make: ");
		String make = sc.nextLine();
		System.out.println("Enter your car model: ");
		String model = sc.nextLine();
		System.out.println("Enter your car year: ");
		int year = sc.nextInt();
		System.out.println("Enter your car price: ");
		double price = sc.nextDouble();
		
		Car newCar = new Car(name,make,model,year,price);
		arr[currentSize] = newCar;
		
		return arr;

	}

}
