/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: Abstract superclass of all shapes. Showcases important methods used for displaying tiles and for sorting in room class*/

abstract class Tiles implements Comparable<Tiles> { //Comparable interface allow tiles to sort themselves based on area, colour, and perimeter.
	
	public abstract String toString(); //Method that returns information of the tile which is used for displaying tiles on screen
	public abstract double getArea(); //Method that returns area which is used for sorting in room class.
	public abstract double getPerimeter(); //Method that returns perimeter which is used for sorting in room class.
	public abstract String getColour(); //Method that returns colour which is used for sorting in room class.
	
}
