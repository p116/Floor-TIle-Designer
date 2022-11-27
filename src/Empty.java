/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Empty class that represents empty tiles in the 2D array. Inherits from tile class*/

public class Empty extends Tiles{

	public String toString() {
		//Returns empty so user can see the empty tile when room is displayed
		return "[EMPTY]";
	}

	//Returns area and perimter of 0 as it has nothing when the tile is empty
	public double getArea() {
		return 0;
	}
	
	public double getPerimeter() {
		return 0;
	}
	
	//Returns a null colour because an empty tile doesn't have a colour
	public String getColour() {
		return null;
	}

	//Allows comparability to other tile objects
	public int compareTo(Tiles o) {
		return 0;
	}


}
