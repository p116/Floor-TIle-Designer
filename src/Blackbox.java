import java.util.Scanner;

/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Blackbox class that displays test cases of each method*/

public class Blackbox {

	public static void main(String args[]) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Test case 1 showcases the getInt method which forces the user to only input an int");
		Client.getInt("\nEnter an int (q to exit): ");
		System.out.println("\nTest case 1 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 2 showcases the getDouble method which forces the user to only input a double");
		Client.getDouble("\nEnter a double (q to exit): ");
		System.out.println("\nTest case 2 Ended. Press enter to continue");
		input.nextLine();

		System.out.println("Test case 3 showcases the getColour method which forces the user to only input a colour");
		Client.getColour("\nEnter an colour (q to exit): ");
		System.out.println("\nTest case 3 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 4 showcases the round method which rounds a number to a certain precision of decimal points");
		System.out.println(Client.round(Client.getDouble("\nEnter a double: "), Client.getInt("Enter the number of decimal places you want to round to: ")));
		System.out.println("\nTest case 4 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 5 showcases the initialize method which fills each tile of a room to an empty tile that can be filled later by the user.");
		System.out.println("Test case 5 also showcases the display method which displays the room of tiles to the user");
		Room.row = Client.getInt("Enter rows (q to exit): "); 
		Room.col = Client.getInt("Enter columns (q to exit): "); 
		Room userRoom = new Room(Room.row, Room.col);	
		userRoom.initialize();
		userRoom.display();
		System.out.println("\nTest case 5 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 6 showcases the dimCheck method which checks to see if the dimension entered by a user is valid");
		System.out.println("We will assume that the user is creating a rectangle object and the maximum length and width of a tile is 4ft.");
		Room room = new Room(3,3);
		room.initialize();
		Room.maxLength = 4;
		Room.maxWidth = 4;
		double recL = Client.dimCheck(Client.getDouble("Enter the length (q to exit): ")); 
		double recW = Client.dimCheck(Client.getDouble("Enter the width (q to exit): ")); 
		String rcolour = Client.getColour("Enter the colour (q to exit): ");
		Rectangle r = new Rectangle(recL, recW, "RED"); 
		System.out.println(r.toString());
		System.out.println("\nTest case 6 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 7 showcases the dimCheckRad method which checks to see if the radius entered by a user is valid");
		System.out.println("We will assume that the user is creating a circle object and the maximum length and width of a tile is 4ft.");
		room.initialize();
		double rad = Client.dimCheckRad(Client.getDouble("Enter the radius (q to exit): ")); //Asks and sets the radius from the user 
		String colour = Client.getColour("Enter the colour (q to exit): "); //Asks and sets the colour from the user 
		Circle c = new Circle(rad, colour); //Creates circle object from parameters entered by user
		System.out.println(c.toString());
		System.out.println("\nTest case 7 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 8 showcases the newTile and placeTile method which allows the user to create and place a tile on the grid");
		System.out.println("We will assume that the maximum length and width of a tile is 4ft and a 3x3 empty grid is created for us");
		room.initialize();
		room.placeTile(room.newTile()); //Asks user for tile, then asks user where to place that tile
		room.display(); //Shows the current room
		System.out.println("\nTest case 8 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 9 showcases the deleteTile method which allows the user to delete a tile from the grid");
		System.out.println("Let's try to delete the tile that we just created");
		room.display(); //Shows the current room
		room.deleteTile();
		room.display();
		System.out.println("\nTest case 9 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Test case 10 showcases the randomFloor method and sortArray method. It allows the user to fill the floor with random generated tiles.");
		System.out.println("All of the tiles abide by the maximum length and width restrictions");
		System.out.println("You can also sort them by colour, area, or perimeter");
		System.out.println("Let's use the same room we have been using previously. It has has maximum dimensions of 4ft and is a 3x3 floor.");
		room.randomFloor(); //Shows the current room
		room.display();
		room.sortArray();
		room.display();
		System.out.println("\nTest case 10 Ended. Press enter to continue");
		input.nextLine();
		
		System.out.println("Finally, test case 11 showcases the getTotalArea and pay methods. getTotalArea returns the value of the total area of the floor");
		System.out.println("The pay method allows the user to pay for the room. However, it is only payable if the entire room is filled with tiles. Let's say the cost per square foot is $3.");
		System.out.println("Let's first see the getTotalArea method. After that, delete a tile. Then, fill in the empty tile with your own design and then pay for the entire room");
		room.display();
		System.out.println("Total area: " + room.getTotalArea() + "ft^2");
		room.deleteTile();
		room.pay(3);
		room.placeTile(room.newTile());
		room.pay(3);
		System.out.println("Test case 11 ended. This marks the end of the blackbox testing. All features have been showcased.");
		
	}
	
}
