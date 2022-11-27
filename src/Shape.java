/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Shape tile class. Superclass of all other shapes. Inherits from Abstract tile class*/

public class Shape extends Tiles{

	//Fields that each shape has. Each shape will have an area, perimeter, and colour
	public String colour; 
	public double area, perimeter; 

	//Constructor for base shape which has values of area and perimeter of 0
	//Only can be accessed by subclasses as shape constructor won't be used outside of subclasses
	protected Shape() {

		area = perimeter = 0; 
	} 

	//Method that each shape has. Returns null for shape
	public String toString() {
		return null;
	}

	//Method that returns area of shape. Used for sorting method in room class.
	public double getArea() {
		return this.area;
	}

	//Method that compares each shape as a tile to one another. Returns a value which is used for sorting method in room class.
	public int compareTo(Tiles o) {
		return 0;
	}

	//Method that returns each shape's perimeter. Used for sorting method in room class.
	public double getPerimeter() {
		return this.perimeter;
	}

	//Method that returns each shape's colour. Used for sorting method in room class.
	public String getColour() {
		return this.colour;
	}
}