//Needed Imports
import java.util.Scanner;

public class Song {
	
	private static String name;		//Name of the Song
	
	//Creating new Song through user input
	public Song() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the song?: ");
		name = input.nextLine();
	}
	//Creating new Song through text
	public Song(String name) {
		Song.name = name;
	}
	
	//Getting the name of the Song
	public String getName() {
		return name.toString();
	}
	
	//Setting the name of the song
	public boolean setName(String name) {
		Song.name = name;
		return Song.name == name;
	}
}
