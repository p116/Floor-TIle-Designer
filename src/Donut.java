/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Donut tile class. Inherits from Ellipse class.*/

public class Donut extends Ellipse {

	//Constructor of donut
	public Donut(double rad1, double rad2, String donutColour) { 
		/*Uses ellipse constructor instead of circle because circle has 1 radius only while ellipse has 2. 
		Donut's outer radius can be represented as radius2 while inner radius can be radius1.*/
		super(rad1, rad2, donutColour);
		//Computes and saves area and perimeter right as the object is created so it doesn't have to be calculated later
		this.computeArea();
		this.computePerimeter();
	} 

	//Method that computes perimeter by using object's values and sets object's perimeter value
	protected void computePerimeter() {
		//Adds perimeter of inner radius and outer radius together to get total Donut radius
		perimeter =  (2 *Math.PI * radius1) + (2 *Math.PI * radius2); 
	}
	
	//Method that computes area by using object's values and sets object's area value
	protected void computeArea () {
		//Takes area of larger radius and subtracts area of smaller radius to get total donut radius
		area = (Math.PI * radius2 * radius2) - (Math.PI * radius1 * radius1);
	}
	
	//Method that displays all the important variables and values of half-circle. Used to display itself in a tile grid when created by user.
	public String toString() {
		return("[" + "DON IR:" + radius1 + " OR: " + radius2 + " c:" + colour + "]");
	}
}