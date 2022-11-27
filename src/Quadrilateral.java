/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Quadrilateral tile class. Inherits from Shape class.*/

public class Quadrilateral extends Shape {

	//Fields that each quadrilateral object has. Length and width for rectangle and square. Base1, Base2, and Slant side for trapezoid
	protected double length, width, b1, b2, ss; 

	//Constructor used for creating rectangle and square tiles. Each rectangle/square tile uses this constructor to make itself.
	protected Quadrilateral(double objLength, double objWidth, String objColour) { 
		//Assigning objects values to what was entered by user.
		length = objLength; 
		width = objWidth; 
		colour = objColour;
	} 

	//Constructor used for creating trapezoid tiles. Each trapezoid tile uses this constructor to make itself. 
	protected Quadrilateral(double objBase1, double objBase2, double objSlant, String objColour) {
		//Assigning objects values to what was entered by user.
		b1 = objBase1;
		b2 = objBase2;
		ss = objSlant;
		colour = objColour;
	} 
}