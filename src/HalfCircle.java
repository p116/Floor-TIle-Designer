/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Half-circle tile class. Inherits from Circle class.*/

public class HalfCircle extends Circle {
 
	//Constructor of rectangle
	public HalfCircle(double rad, String halfCirColour) 
	{ 
		super(rad, halfCirColour); //Uses super contructor of Circle class, which routes it to ellipse constructor
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea();
		this.computePerimeter();
	} 
	
	//Computes area by using object's values and sets object's area value
	protected void computeArea() { 
		//Same formula as circle but divided by 2 as it's a half-circle
		area = (Math.PI * radius1 * radius1)/2; 
	} 

	//Computes perimeter by using object's values and sets object's perimeter value
	protected void computePerimeter() {
		//Takes half the circumference and adds the diameter to get perimeter
		perimeter = (2 *radius1) + (Math.PI * radius1); 
	}
	
	//Displays all the important variables and values of half-circle. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "HC R:" + radius1 + " c:" + colour + "]");
	}
}