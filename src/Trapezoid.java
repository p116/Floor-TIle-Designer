/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Trapezoid tile class. Inherits from Quadrilateral class.*/

public class Trapezoid extends Quadrilateral {

	//Constructor that takes values of bases, slant side, and colour. Uses quadrilateral constructor to do so. 
	public Trapezoid(double base1, double base2, double slantSide, String trapColour) {
		super(base1, base2, slantSide, trapColour);
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea();
		this.computePerimeter();
	} 

	//Computes area by using object's values and sets object's area value 
	private void computeArea() { 
		double avgBase = (b1 + b2)/2; //Calculates average base
		width = Math.sqrt((((b2 - b1)/2)*((b2 - b1)/2) + ss*ss)); //Calculates height using Pythagorean theorem
		area = avgBase * width; //(Base1 + Base2)/2 times height simplified formula
	} 
	//Computes perimeter by using object's values and sets object's perimeter value
	private void computePerimeter() { 
		//Calculates perimeter by adding up each side
		perimeter = 2*ss + b1 + b2; 
	} 

	//Displays all the important variables and values of rectangle. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "TRP B1:" + b1 + " B2: " + b2 + " H: " + width + " c:" + colour + "]");   
	}
}