//Needed Imports
import java.util.Scanner;

public class Album {
	
	private static String name;		//Name of the Album
	
	//Creating new Album through user input
	public Album() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the song?: ");
		name = input.nextLine();
	}
	//Creating new Album through text
	public Album(String name) {
		Album.name = name;
	}
	
	//Getting the name of the Album
	public String getName() {
		return name.toString();
	}
	
	//Setting the name of the Album
	public boolean setName(String name) {
		Album.name = name;
		return Album.name == name;
	}
}
