/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Ellipse tile class. Inherits from Shape class.*/

public class Ellipse extends Shape {

	//Fields that each ellipse object has. Radius 1 for one axis and radius 2 for the other axis of a circular object. 
	protected double radius1, radius2; 
	
	//Constructor used for creating ellipses, circles, donuts, and half-circles.
	public Ellipse(double rad1, double rad2, String ellColour) {
		
		//Assigning objects values to what was entered by user.
		radius1 = rad1; 
		radius2 = rad2; 
		colour = ellColour;
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea();
		this.computePerimeter();
	} 
	
	//Computes area by using object's values and sets object's area value
	protected void computeArea() { 
		//Base ellipse area formula
		area = radius1 * radius2 * Math.PI; 
	} 

	//Computes perimeter by using object's values and sets object's perimeter value
	protected void computePerimeter() { 
		//Ramanujan's approximate formula for ellipse perimeter
		perimeter = Math.PI * (3*(radius1 + radius2) - Math.sqrt((3*radius1 + radius2) + 3*radius2 + radius1)); 
	} 
	
	//Displays all the important variables and values of ellipse. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "ELLIPSE R1:" + radius1 + " R2: " + radius2 + " c:" + colour + "]");
	}
	
}