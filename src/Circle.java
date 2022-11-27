/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Circle tile class. Inherits from Ellipse class.*/
public class Circle extends Ellipse 

{
	
	//Constructor of Circle
	public Circle(double x, String cirColour) { //Takes only 1 radius and 1 colour
		//Uses ellipse constructor and sets radius 1 and radius 2 to equal the same value and defines colour of object
		super(x, x, cirColour);
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea();
		this.computePerimeter();
	} 

	//Method that computes perimeter by using object's values and sets object's perimeter value
	protected void computePerimeter() {
		//Uses circumference formula (2*pi*r)
		perimeter = 2 *Math.PI * radius1; 
	}

	//Method that displays all the important variables and values of half-circle. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "CIR R:" + radius1 + " c:" + colour + "]");
	}
}