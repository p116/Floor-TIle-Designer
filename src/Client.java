/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Client class that executes code to the user and holds methods used to check user input*/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {

	//Method that displays all the options of the program
	public static void options() {
		System.out.println("\nEnter 1 to generate a randomly designed floor");
		System.out.println("Enter 2 to create a new tile");
		System.out.println("Enter 3 to to delete a tile");
		System.out.println("Enter 4 to display the floor");
		System.out.println("Enter 5 for the total cost");
		System.out.println("Enter 6 for the total area");
		System.out.println("Enter 7 to clear all tiles");
		System.out.println("Enter 8 to pay for the room");
		System.out.println("Enter 9 to sort the room");
		System.out.println("Enter Q to quit: ");
	}	

	//Method that returns a valid dimension entered by the user
	public static Double dimCheck(double dimension) { //Takes parameter of dimension entered by user
		//Loops until the user enters valid dimension
		while(true) {
			//If the dimension does not fit within the room
			if (dimension > Math.min(Room.maxLength, Room.maxWidth)) {
				//Ask user to re-enter the dimension
				dimension = getDouble("Dimension does not fit. Re-enter the dimension: ");
			}
			else { //If all is good, then break
				break;
			}
		}
		return dimension; //Return the valid user dimension
	}
	
	//Method that returns a valid radius entered by the user
	public static Double dimCheckRad(double userRad) { //Takes parameter of radius entered by user
		Scanner dimInput = new Scanner(System.in);
		//Loops until the user enters valid radius
		while(true) {
			//If the diameter does not fit within the room
			if (userRad*2 > Math.min(Room.maxLength, Room.maxWidth)) {	
				//Ask user to re-enter the dimension
				userRad = getDouble("Dimension does not fit. Re-enter the dimension: ");
			}
			else { //If all is good, then break
				break;
			}
		}
		return userRad; //Return the valid user radius
	}

	//Method that checks to see that the user has input a valid integer value
	public static int getInt(String prompt) { //Takes a string that will be printed as a prompt to the user
		Scanner sc = new Scanner(System.in); //Initalize scanner to scan for entry by user
		System.out.print(prompt); //Prints prompt

		//Loops until user inputs valid int
		while (!sc.hasNextInt()) { //While the scanner does not have an int

			String input = sc.next();
			if (input.equalsIgnoreCase("q")) {
				System.out.println("Have a nice day!.");
				System.exit(0);
			}
			//Asks user to re-input a valid value
			System.out.println("Invalid. Re-enter the value: ");


			//If user inputs q or Q, then exit program

		}
		return sc.nextInt(); //Return valid integer value input by user
	}

	//Method that checks to see that the user has input a valid double value
	public static double getDouble(String prompt) { //Takes a string that will be printed as a prompt to the user
		Scanner sc = new Scanner(System.in); //Initalize scanner to scan for entry by user
		System.out.print(prompt); //Prints prompt

		//Loops until user inputs valid double
		while (!sc.hasNextDouble()) { //While the scanner does not have a double
			String input = sc.next();
			//If user inputs q or Q, then exit program
			if (input.equalsIgnoreCase("q")) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
			//Asks user to re-input a valid value
			System.out.println("Invalid. Re-enter the value: ");


		}
		return sc.nextDouble(); //Return valid double value input by user

	}

	//Method that checks to see that the user has input a valid colour string
	public static String getColour(String prompt) { //Takes a string that will be printed as a prompt to the user
		Scanner sc = new Scanner(System.in); //Initialize scanner to scan for entry by user
		System.out.print(prompt);//Prints prompt and options of colours to choose from
		System.out.println("Options are red, blue, green, yellow, orange, purple, or pink.");

		//Loops until user inputs valid colour		
		while (true) {

			String input = sc.next();
			//if input is a q, then quit
			if (input.equalsIgnoreCase("q")) {
				System.out.println("Have a nice day!.");
				System.exit(0);
			}

			//Checks through each item in colours array
			for (int j = 0; j < Room.colours.length; j++) {
				if (input.equalsIgnoreCase(Room.colours[j])) //If the input matches the colour array, then return the colour
					return input.toUpperCase();
			}
			//If not, then input valid colour
			System.out.println("Invalid Colour. Re-enter one of the options: ");
		}
	}

	//Method that returns a value which is rounded
	public static double round(double value, int precision) { //Takes the parameters of a value and precision of how many decimal places to round to
		//Calculates scale of rounding by using precision value
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale; //Returns value rounded using Math.round function and with precision decimal values
	}

	//Main program
	public static void main(String args[]) throws FileNotFoundException {
		//Declare variables that will be used to make rooms and calculate prices
		int row, col;
		double userCost;

		TitleArt titleart = new TitleArt();

		System.out.println(titleart.title());

		//Asking user for specifications of a room using methods created above to ensure they input valid values
		Room.row = getInt("Enter rows of floor tiles: "); 
		Room.col = getInt("Enter columns of floor tiles: "); 
		Room.maxLength = getDouble("Enter the maximum length of a tile: ");
		Room.maxWidth = getDouble("Enter the maximum width of a tile: ");
		userCost = getDouble("Enter the price per square foot in dollars: ");

		//Initializes room with set amount of rows and columns declared by user
		Room room = new Room(Room.row, Room.col);	

		//Initializes room to be all empty tiles
		room.initialize();

		//Runs forever until user exits program by entering q or Q
		while (true) {
			options();//Display options to user
			Scanner input2 = new Scanner(System.in); //Scanner to take user input
			String userInput = input2.nextLine();
			//User chose to randomize the floor 
			if (userInput.equals("1")) {
				room.randomFloor();
				room.display();
			}
			//User chose to create a new tile
			else if (userInput.equals("2")) {
				room.placeTile(room.newTile()); //Asks user for tile, then asks user where to place that tile
				room.display(); //Shows the current room
			}
			//User chose to delete a tile
			else if (userInput.equals("3")) {
				room.deleteTile(); //Asks user which tile to delete
				room.display(); //Shows the current room
			}
			//User chose to see the room currently
			else if (userInput.equals("4")) {
				room.display(); //Shows the current room
			}
			//User chose to calculate total price of the room
			else if (userInput.equals("5")) {
				System.out.println("Total Cost: $" + round(userCost * room.getTotalArea(), 2)); //Caluclates and displays total cost rounded to nearest tenths
			}
			//User chose to see total area of room so far
			else if (userInput.equals("6")) {
				System.out.println("Total area: " + room.getTotalArea() + "ft^2"); //Displays total area
			}
			//User chose to clear all tiles
			else if (userInput.equals("7")) {
				room.initialize(); //Initializes room to all empty tiles
				room.display(); //Displays room
			}
			//User chose to pay for the room
			else if (userInput.equals("8")) {
				room.pay(userCost); //Takes userCost and calculates total price and checks if room is full so user can pay 
			}
			//User chose to sort the room by attribute
			else if (userInput.equals("9")) {
				room.sortArray(); //Sorts 2D array
				room.display(); //Displays it to user
			}
			//If user enters q, then quit
			else if (userInput.equalsIgnoreCase("q")) {
				System.out.println("\nHave a nice day!");
				System.exit(0);
			}


		}
	}
}
