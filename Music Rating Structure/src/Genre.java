//Needed Imports
import java.util.Scanner;

public class Genre {
	
private static String name;		//Name of the Genre
	
	//Creating new Genre through user input
	public Genre() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("What is the name of the genre?: "); //TODO Make it so only a select list of genres can be added by the user
		name = input.nextLine();
	}
	//Creating new Genre through initializing name
	public Genre(String name) {
		Genre.name = name;
	}
	
	//Getting the name of the Genre
	public String getName() {
		return name.toString();
	}
	
	//Setting the name of the Genre
	public boolean setName(String name) {
		Genre.name = name;
		return Genre.name == name;
	}
	
}
