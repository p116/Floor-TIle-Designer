/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Rectangle tile class. Inherits from Quadrilateral class.*/

public class Rectangle extends Quadrilateral {

	public Rectangle(double x, double y, String recColour) { //Constructor of rectangle
		
		//Assigning objects values to what was entered by user and routing them to Quadrilateral constructor which actually makes the object.
		super(x, y, recColour); 
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea(); 
		this.computePerimeter();
	} 

	//Computes area by using object's values and sets object's area value
	protected void computeArea() { 

		area = length * width; 
	} 
	//Computes perimeter by using object's values and sets object's perimeter value
	protected void computePerimeter() { 

		perimeter = 2*(length + width); 
	} 
	
	//Displays all the important variables and values of rectangle. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "REC L:" + length + " W: " + width + " c:" + colour + "]");   
	}
	
}