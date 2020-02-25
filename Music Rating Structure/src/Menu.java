//Needed Imports
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Driver Class with Main Menu
public class Menu {
	//Constant Variables
	Scanner input = new Scanner(System.in);
	private final static String FILE_PATH = "myDatabase.bin";
	private int LOWEST_CHOICE = 0;
	private int HIGHEST_CHOICE = 6;
	
	//Instance Variables
	boolean exitChoice;
	static TuneArray tunes = new TuneArray();
	
	//Main Method where the Menu is used and shown
	public static void main(String[] args) throws IOException, InterruptedException {
		//Importing all tunes from the file
		tunes = importFromFile(FILE_PATH);
		
		//Main Menu
		Menu menu = new Menu();
		menu.runMainMenu();
	}
	
	//Prints the Main Menu
	private static void printHeader() {
		System.out.println("\n+-------------------------------------------+");
		System.out.println("|       Personal Music Rating Database      |");
		System.out.println("|                ICH Programs               |");
		System.out.println("+-------------------------------------------+");
	}
	
	//Prints the Options Menu
	private static void printMainMenu() {
		System.out.println("\nPlease pick a menu option!");
		System.out.println("0) Add a tune");
		System.out.println("1) Remove a tune");
		System.out.println("2) Search for a tune");
		System.out.println("3) Print all tunes");
		System.out.println("4) Print all tunes by rating");
		System.out.println("5) Clear all tunes");
		System.out.println("6) Save and Exit");
		//Change Constants at top if menu is changed
	}	
	
	//Runs and maintains the menu
	public void runMainMenu() {
		printHeader();
		while (!exitChoice) {
			printMainMenu();
			int choice = getMenuInput();
			mainMenuAction(choice);
		}
	}
	
	//Performs task chosen by user from menu
	private void mainMenuAction(int choice) {
		switch(choice) {
		case 0:
			addTune();
			break;
		case 1:
			removeTune();
			break;
		case 2:
			searchTunes();
			break;
		case 3:
			printTunes();
			break;
		case 4:
			printTunesRating();
			break;
		case 5:
			clearTunes();
			break;
		case 6:
			exitChoice = true;
			//Writing to the file to save
			try {
				writeToFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Exiting and Closing Resources
			exitCall();
		default:
			System.err.println("Something unexepected has happened.");
		}	
	}
	
	//Add Tune in Menu
	private static void addTune() {
		Scanner input = new Scanner(System.in);
		String song, album, author, genre;
		Rating rating;
		int length = -1;
		Tune newSong = new Tune();
		
		//Naming Components and Length
		System.out.print("What is the name of the Song?: ");
		song = input.nextLine();
		newSong.setSong(song);
		System.out.print("What is the name of the Album?: ");
		album = input.nextLine();
		newSong.setAlbum(album);
		System.out.print("What is the name of the Author?: ");
		author = input.nextLine();
		newSong.setAuthor(author);
		System.out.print("What is the name of the Genre?: ");
		genre = input.nextLine();
		newSong.setGenre(genre);
		//Checking User input for an integer
		while(length < 0) {
			try {
				System.out.print("What is the length of the song in seconds?: ");
				length = Integer.parseInt(input.nextLine()); 
				newSong.setLength(length);
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter the number of seconds as an integer.");
			}
		}
		//Creating Rating (input in Rating class)
		rating = new Rating();
		newSong.setFinalRating(rating);
		
		//Adding the tune
		tunes.add(newSong);
		System.out.println("\nAdded Song\n" + newSong.tuneToString());
		pressEnterKeyToContinue();
	}
	
	//Remove Tune in Menu
	private static void removeTune() {
		Scanner input = new Scanner(System.in);
		String songName;
		Tune tempTune;
		
		//Removing song by Song name
		System.out.print("\nWhat song would you like to remove?: ");
		songName = input.nextLine();

		for (int i = 0; i <= tunes.size() -1 ; i++) {
			if (tunes.get(i).getSong().equals(songName)) {
				tempTune = tunes.get(i);
				tunes.remove(tunes.get(i));
				System.out.println("Removed a song!\n" + tempTune.tuneToString());
				pressEnterKeyToContinue();
				return;
			}
		}
		System.out.println("Im sorry, the song is not found within the database.");
	}
	
	//Search Tune in Menu
	private void searchTunes() {
		Scanner input = new Scanner(System.in);
		String songName;
		Tune tempTune;
		
		//Input for a song by name
		System.out.print("\nWhat song would you like to search for more details?: ");
		songName = input.nextLine();
		//Searching for the song
		for (int i = 0; i <= tunes.size() -1 ; i++) {
			if (tunes.get(i).getSong().equals(songName)) {
				tempTune = tunes.get(i);
				System.out.println("Showing Full Details\n" + tempTune.tuneToString());
				pressEnterKeyToContinue();
				return;
			}
		}
		System.out.println("Im sorry, the searched song is not found within the database.");
	}
	
	//Print quick view of all Tunes in database
	private static void printTunes() {
			System.out.println("\nNow Printing All Tunes");
			tunes.printQuickTunes();
	}
	
	//Clears the database of all tunes
	private void clearTunes() {
		System.out.print("Now clearing the entire database");
		dotDelay(3);
		tunes.clear();
		//Newline
		System.out.println();
	}
	
	//Prints the tunes in order of rating
	private void printTunesRating() {
		tunes.sortByRating();
		for (int i = 0; i <= tunes.size() - 1; i++) {
			Tune temp = tunes.get(i);
			//Formatting to two decimals and printing
			String rating = String.format("%.2f", temp.getFinalRating());
			System.out.println(temp.getSong() + "    [" + temp.getAuthor() + "]:" + rating);
		}
	}
	
	//Gets user input to create a new Tune
	public int getMenuInput() {
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		//Validating input for an int
		while (choice < LOWEST_CHOICE || choice > HIGHEST_CHOICE) {
			try {
				System.out.print("Please enter your choice: ");
				choice = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid Selection! Please try again.");
			}
		}
		return choice;
	}
	
	//Writes Tunes to a binary file
	public static void writeToFile() throws IOException {
		FileOutputStream out = new FileOutputStream("myDatabase.bin");
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		//Writing one by one to file
		for (int i = 0; i < tunes.size(); i++) {
			objOut.writeObject(tunes.get(i));	
		}
		//Adds a tune to the end with a negative one to signal the end of the file
		Tune endTune = new Tune();
		endTune.setSong("END OF FILE");
		endTune.setLength(-1);
		objOut.writeObject(endTune);
		objOut.close();
	}
	
	//Imports Tunes from binary file
	public static TuneArray importFromFile(String filepath) throws FileNotFoundException {
		System.out.print("Importing Tunes From File");
		dotDelay(5);
		//Newline
		System.out.println();
		
		
		TuneArray tempArray = new TuneArray();
		int count = 0;		//Keeps track for printing
		FileInputStream fileIn = new FileInputStream(filepath);
		try {
			@SuppressWarnings("resource")
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			//Adding objects to database until a song with length -1 appears
			boolean cont = true;
			while (cont) {
				Tune obj = (Tune) objectIn.readObject();
				if (obj.getLength() != -1) {
					tempArray.add(obj);
					count++;
					System.out.println("Object " + count + ": " + tempArray.get(count - 1) );
				} else if (obj.getLength() == -1) {
					cont = false;
					return tempArray;
				} 
			}
			objectIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return tempArray;
	}
	
	//Exits the Structure
	public void exitCall() {
		System.out.print("Well, I hope to see you soon! Now Exiting");
		dotDelay(3);
		System.gc(); //Garbage Collection
		System.exit(0); //Exiting
	}
	
	//Period Printing Thread Delay 
	public static void dotDelay(int totalDots) {
		for (int i = 1; i <= totalDots; i++) {
			try {
				Thread.sleep(950);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
	}
	
	//Makes user press enter to move forward
	private static void pressEnterKeyToContinue() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nPress Enter to continue...");
		try {
			input.nextLine();
		}
		catch (Exception e) {
			System.err.println("Something unexepected has happened.");
		}
	}
}