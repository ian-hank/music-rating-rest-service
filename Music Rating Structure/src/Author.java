//Needed Imports
import java.util.Scanner;

public class Author {
	private static String name;		//Name of the Author
	
	//Creating new Author through user input
	public Author() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("What is the name of the Author?: ");
		name = input.nextLine();
	}
	//Creating new Author through initializing name
	public Author(String name) {
		Author.name = name;
	}
	
	//Getting the name of the Author
	public String getName() {
		return name.toString();
	}
	
	//Setting the name of the Author
	public boolean setName(String name) {
		Author.name = name;
		return Author.name == name;
	}
}
