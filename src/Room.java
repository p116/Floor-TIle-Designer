/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Room class that holds the array of tiles. Also hosts the array of tiles*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Room {
	
	
	public static double maxLength, maxWidth; //Variables that hold values of max dimensions of tiles
	public static int row, col; //Variables that holds values of tiles array's number of rows and columns
	private Tiles[][] tiles; //2D Tiles array that holds tile objects. Only accessed within its class
	public static String[] colours = {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "PURPLE", "PINK"}; //Array that holds options of colours

	//Constructor of Room object that initializes the tiles array with the rows and columns input by the user
	public Room(int arrayRow, int arrayCol) { 
		tiles = new Tiles [arrayRow][arrayCol];
	}

	//Method that initializes all the tiles to be an Empty tile
	public void initialize() {
		//Iterates through each spot in the tile array
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = new Empty(); //Makes each tile an Empty tile so user can fill it in with their own designs later
			}
		}
	}

	//Method to display the tiles array to the user
	public void display() {
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				System.out.print(tiles[x][y] + " "); //Prints out the toString method for each tile alongside a space in between each tile
			}
			System.out.println(""); //Creates a space per each row 
		}
	}

	//Method that returns a tile created by the user
	public Tiles newTile() {
		//Displays options
		System.out.println("\nEnter 1 for a Circle");
		System.out.println("Enter 2 for a Donut");
		System.out.println("Enter 3 for an Ellipse");
		System.out.println("Enter 4 for a Semi-circle");
		System.out.println("Enter 5 for a Rectangle");
		System.out.println("Enter 6 for a Square");
		System.out.println("Enter 7 for a Trapezoid");
		System.out.println("Enter Q to quit: ");
		int choice = Client.getInt(""); //Gets user's choice of what they want to make

		//Has different scenarios for each input the user enters
		switch(choice) {

		case 1: //User enters 1 to make a circle
			double rad = Client.dimCheckRad(Client.getDouble("Enter the radius: ")); //Asks and sets the radius from the user 
			String colour = Client.getColour("Enter the colour: "); //Asks and sets the colour from the user 
			Circle c = new Circle(rad, colour); //Creates circle object from parameters entered by user
			return c; //Returns created circle

		case 2: //User enters 2 to make a Donut
			double innerRad = Client.dimCheckRad(Client.getDouble("Enter the inner radius: ")); //Asks and sets the inner radius from the user
			double outerRad = Client.dimCheckRad(Client.getDouble("Enter the outer radius: ")); //Asks and sets the outer radius from the user

			while(true) { //Loops until the user inputs valid radii for donut
				//Inner radius and outer radius cannot be the same. Donut will not exist otherwise.
				if (innerRad == outerRad) {
					//Promots user to re-input values
					innerRad = Client.dimCheckRad(Client.getDouble("The radii cannot be the same. Re-enter the inner radius: "));
					outerRad = Client.dimCheckRad(Client.getDouble("Re-enter the outer radius: "));
				}
				else if (innerRad > outerRad) { //Inner radius has to be less than outer radius. Donut will not exist otherwise.
					//Promots user to re-input values
					innerRad = Client.dimCheckRad(Client.getDouble("The inner radius cannot be greater than the outer radius. Re-enter the inner radius: "));
					outerRad = Client.dimCheckRad(Client.getDouble("Re-enter the outer radius: "));
				}

				else {
					//If all is well, then it exits the loop
					break;
				}
			}

			String dcolour = Client.getColour("Enter the colour: "); //Asks and sets the colour from the user 
			Donut d = new Donut(innerRad, outerRad, dcolour); //Creates donut object from parameters entered by user
			return d; //Returns created donut
			
		case 3: //Users enters 3 to make an ellipse object
			double rad1 = Client.dimCheckRad(Client.getDouble("Enter the dimension of radius 1: ")); //Asks and sets radius 1 from the user
			double rad2 = Client.dimCheckRad(Client.getDouble("Enter the dimension of radius 2: ")); //Asks and sets radius 2 from the user
			String ecolour = Client.getColour("Enter the colour: "); //Asks and sets the colour from the user 
			Ellipse e = new Ellipse(rad1, rad2, ecolour); //Creates ellipse object from parameters entered by user
			return e; //Returns created ellipse
			
		case 4: //Users enters 4 to make a half-circle
			double semiRad = Client.dimCheckRad(Client.getDouble("Enter the radius: ")); //Asks and sets the radius from the user
			String scolour = Client.getColour("Enter the colour: "); //Asks and sets the colour from the user
			HalfCircle h = new HalfCircle(semiRad, scolour); //Creates half-circle object from parameters entered by user
			return h; //Returns created half-circle
			
		case 5: //User enters 5 to make a rectangle object
			
			//Asks user to input length, width, and colour
			double recL = Client.dimCheck(Client.getDouble("Enter the length: ")); 
			double recW = Client.dimCheck(Client.getDouble("Enter the width: ")); 
			String rcolour = Client.getColour("Enter the colour: ");
			Rectangle r = new Rectangle(recL, recW, rcolour); //Creates rectangle object from parameters entered by user
			return r; //Returns created rectangle
			
		case 6: //User enters 6 to make a square object
			
			//Asks user to input side length and colour
			double sideLength = Client.dimCheck(Client.getDouble("Enter the side length: "));
			String sqcolour = Client.getColour("Enter the colour: ");
			Square sq = new Square(sideLength, sqcolour); //Creates square object from parameters entered by user
			return sq; //Returns created square
			
		case 7: //User enters 7 to make a trapezoid object

			//Asks user to input base 1, base 2, and slant side
			double base1 = Client.dimCheck(Client.getDouble("Enter the dimension of base 1: "));
			double base2 = Client.dimCheck(Client.getDouble("Enter the dimension of base 2: "));
			double slant = Client.getDouble("Enter the slant length: ");

			//Checks to see if the height of the trapezoid fits within the tile
			while(true) {
				//If the height of the trapezoid is greater than the maximum width of a tile 
				if (Math.sqrt((((base2 - base1)/2)*((base2 - base1)/2) + slant*slant)) > Room.maxWidth) {
					slant = Client.getDouble("Dimension does not fit. Re-enter the dimension: "); //Asks user to re-enter slant
				}
				else { //If all is good, then exit the loop
					break;
				}
			}

			//Asks user to input colour
			String tcolour = Client.getColour("Enter the colour: ");
			Trapezoid t = new Trapezoid(base1, base2, slant, tcolour); //Creates trapezoid object from parameters entered by user
			return t; //Returns created trapezoid
		}
		return null; //Returns null just if invalid tile is somehow selected
	}

	//Method that places tile down into a space in the 2d tile array
	public void placeTile(Tiles obj) { //Takes the tile that is being placed as a parameter
		Scanner input4 = new Scanner(System.in); 

		//Asks the user where they want to place the tile
		int row = Client.getInt("Enter the row where you want to place this tile: ");
		int col = Client.getInt("Enter the column where you want to place this tile: ");

		//Loops over and over until user enters valid inputs
		while(true) {
			//If the rows/col entered by user is not within the bounds of the array or of the spot is already occupied
			if (row <= 0 || row > tiles.length || col <= 0 || col > tiles[0].length || !(tiles[row-1][col-1] instanceof Empty)) {
				//Asks user to re-enters values
				row = Client.getInt("This space is not valid. Re-enter the row: ");
				col = Client.getInt("Re-enter the column: ");
			}
			else { //If all is good, then break out of the loop
				break;
			}
		}
		//Places tile in the row and col specified by user. Have to subtract 1 from each value because array indexes are 1 less.
		tiles[row-1][col-1] = obj;
	}

	//Method that deletes tile 
	public void deleteTile() {
		Scanner input4 = new Scanner(System.in); 
		//Asks user to input location of which tile they want to delete
		int row = Client.getInt("Enter the row of the tile you want to delete: ");
		int col = Client.getInt("Enter the column of the tile you want to delete: ");

		//Loops over and over if invalid values are entered
		while(true) {
			//If the rows/col entered by user is not within the bounds of the array or of the spot is already empty
			if (row <= 0 || row > tiles.length || col <= 0 || col > tiles[0].length || tiles[row-1][col-1] instanceof Empty) {
				//Asks user to re-input location of tile
				row = Client.getInt("These values are not valid. Re-enter the row:");
				col = Client.getInt("Re-enter the column: ");
				
			}

			else { //If all is good, then exits the loop
				break;
			}
		}

		//Makes the tile at the location the user enter to become an empty tile
		tiles[row-1][col-1] = new Empty();

	}
	
	//Method that returns total area of tiles array
	public Double getTotalArea() {
		double roomArea = 0;

		//Iterates through each tile in the 2D array
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				//Adds up the area of each tile to its total
				roomArea += tiles[x][y].getArea();
			}
		}
		return Client.round(roomArea, 2); //Returns total area of the room rounded to nearest hundredth
	}

	//Method used to pay for the room
	public void pay(double cost) { //Takes userCost as a parameter to calculate total cost

		int emptyCounter = 0; //Variable that keeps track of the number of empty tiles in the room
		
		//Iterates through the entire 2D array
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				if (tiles[x][y] instanceof Empty) {
					//If the tile that the loop is on is an Empty tile, increment 1 to the counter
					emptyCounter++;
				}
			}
		}
		
		/*The user can only pay if the entire room is filled with tiles. 
		If the emptyCounter is 0, meaning if there are no empty tiles, they can pay*/
		if (emptyCounter == 0) {
			//Outputs total cost rounded to 2 decimal places and says bye to the customer
			System.out.println("\nYour total will be $" + Client.round(cost * this.getTotalArea(), 2) + "\nHave a nice day!");
			this.initialize(); //Re-initializes room 
			this.display(); //Displays re-initalized room to customer
		}
		else { //If each tile is not filled, they cannot pay for the room yet
			System.out.println("\nEach tile must be filled before you pay for the room.");
		}
	}

	//Method that fills the room with randomly generated tiles
	public void randomFloor() {
		Random rn = new Random(); //Random object that generates random integers
		int index; //Variable that takes the value of the random integer generated. It's used to determine the colour of the tile.

		//Loop that loops through each element in the 2D array 
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {

				//Chooses a random number from 1-7. Determines which shape the tile will be.
				int randInt = ThreadLocalRandom.current().nextInt(1, 7);

				switch (randInt) {
				case 1: //Tile is a circle
					//Generates a radius that is able to fit within the dimensions of the tile. Rounds the dimension to the nearest tenth.
					double rad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);

					//Chooses a random element from the array of colours to be the colour of the object
					index = rn.nextInt(colours.length);
					Circle c = new Circle(rad, colours[index]); //Create object with random radius and colour from random index of colours array
					tiles[x][y] = c; //Assign the object to a place in the 2D array
					break;
				case 2: //Tile is a donut
					
					//Generate random outer and inner radii that fit within max dimensions of the tile which are rounded to the nearest tenth.
					double outerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
					double innerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
					//Loops until valid dimensions are generated
					while(true) {
						if (innerRad == outerRad) { //If the radii are the same value, regenerate values
							innerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
							outerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
						}
						else if (innerRad > outerRad) { //If the inner radius is greater than the outer radius, regenerate values
							innerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
							outerRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
						}

						else { //If all is good, then leave the loop
							break;
						}
					}
					//Chooses a random element from the array of colours to be the colour of the object
					index = rn.nextInt(colours.length);
					Donut d = new Donut(innerRad, outerRad, colours[index]); //Create donut with randomly generated radii and colour from random index of colours array
					tiles[x][y] = d; //Assign the object to a place in the 2D array
					break;
				case 3: //Tile is an ellipse
					
					//Generates 2 random radii that fit within dimensions of the tile which are rounded
					double rad1 = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
					double rad2 = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
					//Chooses a random element from the array of colours to be the colour of the object
					index = rn.nextInt(colours.length);
					Ellipse e = new Ellipse(rad1, rad2, colours[index]); //Create object with random radius and random colour from random index of colours array
					tiles[x][y] = e; //Assign the object to a place in the 2D array
					break;
				case 4: //Tile is a half-circle
					
					//Generates a random radius that fits within dimensions of the tile. Value is rounded to nearest tenth.
					double semiRad = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)/2), 1);
					//Chooses a random number from the range of 0 to the length of the colours array
					index = rn.nextInt(colours.length);
					HalfCircle h = new HalfCircle(semiRad, colours[index]); //Generates half-circle with random radius and colour from random index of colours array
					tiles[x][y] = h; //Assigns the object to a place in the 2D array
					break;
				case 5: //Tile is a rectangle
					//Generates random length and width which fits in tile dimensions. Values are rounded to the nearest tenth.
					double recL = Client.round(ThreadLocalRandom.current().nextDouble(0.1, maxLength), 1);
					double recW = Client.round(ThreadLocalRandom.current().nextDouble(0.1, maxWidth), 1);
					//Chooses a random number from the range of 0 to the length of the colours array
					index = rn.nextInt(colours.length);
					Rectangle r = new Rectangle(recL, recW, colours[index]); //Generates rectangle with random parameters and colour from random index of colours array
					tiles[x][y] = r; //Assign the object to a place in the array
					break;
				case 6: //Tile is a square
					//Generates random side length which fits in the tile. Value is rounded to the nearest tenth.
					double sideLength = Client.round(ThreadLocalRandom.current().nextDouble(0.1, Math.min(maxLength, maxWidth)), 1);
					//Chooses a random number from the range of 0 to the length of the colours array
					index = rn.nextInt(colours.length); //Chooses a random number from the range of 0 to the length of the colours array
					Square sq = new Square(sideLength, colours[index]); //Creates square with random parameters and colour from random index of colours array
					tiles[x][y] = sq; //Assign object to a place in the array
					break;
				case 7: //Tile is a trapezoid
					//Generates random dimensions which fit within the tile
					double base1 = Client.round(ThreadLocalRandom.current().nextDouble(0.1, maxLength), 1);
					double base2 = Client.round(ThreadLocalRandom.current().nextDouble(0.1, maxLength), 1);
					//Height is randomly generated to ensure the trapezoid can guaranteed fit within the maxWidth of the tile
					double height = Client.round(ThreadLocalRandom.current().nextDouble(0.1, maxWidth), 1);
					//Slant is calculated from randomly generated dimensions of trapezoid and pythagorean theorem
					double slant = Math.sqrt((Math.max(base1, base2) - Math.min(base1, base2))/2*(Math.max(base1, base2) - Math.min(base1, base2))/2 + height*height);
					index = rn.nextInt(colours.length); //Chooses a random number from the range of 0 to the length of the colours array
					Trapezoid t = new Trapezoid(base1, base2, slant, colours[index]); //Creates trapezoid with random parameters and colour from random index of colours array
					tiles[x][y] = t; //Assign object to a place in the array
					break;
				}
			}

		}
	}
	
	//Method to sort the 2D array in order from least to greatest
	public void sortArray() {
		//1D array has to be created to use sorting feature. Will hold same amount of elements as 2D array
		Tiles newArray[] = new Tiles[tiles.length*tiles[0].length];
		
		//Copies each value from the 2D array into the 1D array
		for(int i = 0; i < tiles.length; i++) {
			Tiles[] row = tiles[i];
			for(int j = 0; j < row.length; j++) {
				Tiles tile = tiles[i][j];
				newArray[i*row.length+j] = tile;
			}
		}
		
		//Ask user how they want to sort the array
		int choice = Client.getInt("Enter 1 to sort by area, 2 to sort by perimeter, or 3 to sort by colour");

		switch (choice) {
		case 1: //User chooses to sort by area
			Arrays.sort(newArray, Comparator.comparingDouble(Tiles::getArea)); //Comparing the values of areas to each tile to each tile to sort the array.
			break;
		case 2: //User chooses to sort by perimeter
			Arrays.sort(newArray, Comparator.comparingDouble(Tiles::getPerimeter)); //Comparing the values of perimeters to each tile to sort the array.
			break;
		case 3: //User chooses to sort by colour
			Arrays.sort(newArray, Comparator.comparing(Tiles::getColour)); //Comparing the values of colours to each tile to each tile to sort the array.
		}
		
		//After array is sorted, this loop copies the values of the 1D array back into the 2D array
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				tiles[i][j] = newArray[ (i * col) + j];

	}
}
