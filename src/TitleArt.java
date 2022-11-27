/*Author: Shubhkarman Pruthi
  Date: 1 February, 2021
  Description: TitleArt class that is used to display the big title in the beginning of the program*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TitleArt {

	public String title() throws FileNotFoundException { //Returns string of title from Text File
		
		//Declaring where to find the file and scanner that will read the file
		File file = new File("./Title/Title.txt"); 
		Scanner scan = new Scanner(file);
		
		//Adds each line to a string
		String titleContent = ""; //Holds all the content from the file
		//Loops until there aren't any more lines to read
		while(scan.hasNextLine()) {
			titleContent = titleContent.concat(scan.nextLine() + "\n"); //Concatenates itself and contains the content of the whole file
		}
		return titleContent; //Returns content of the text file
	}

}
