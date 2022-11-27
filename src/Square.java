/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Square tile class. Inherits from Rectangle class.*/
public class Square extends Rectangle 

{  
	//Constructor of square tile that takes values and makes a tile based upon them.
	public Square(double side, String sqColour) 
	{ 
		super(side, side, sqColour); //Uses super constructor of rectangle, which uses Quadrilateral. 
	} 

	//Displays all the important variables and values of rectangle. Used to display itself in a tile grid when created by user.
	public String toString() {

		return("[" + "SQ s:" + length + " c:" + colour + "]");

	}

}