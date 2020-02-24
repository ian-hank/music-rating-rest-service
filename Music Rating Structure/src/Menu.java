import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu {
	//Constant Variables
	private final static String FILE_PATH = "myDatabase.bin";
	private int LOWEST_CHOICE = 0;
	private int HIGHEST_CHOICE = 5;
	
	//Instance Variables
	boolean exitChoice;
	static TuneArray tunes = new TuneArray();
	
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
	//Prints the Start Menu
	private static void printMainMenu() {
		System.out.println("\n0) Add a tune");
		System.out.println("1) Remove a tune");
		System.out.println("2) Search for a tune");
		System.out.println("3) Print all tunes");
		System.out.println("4) Clear all tunes");
		System.out.println("5) Save and Exit");
		//Change Constants at top if menu is changed
	}	
	
	public void runMainMenu() {
		printHeader();
		while (!exitChoice) {
			printMainMenu();
			int choice = getMenuInput();
			mainMenuAction(choice);
		}
	}
	
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
			clearTunes();
			break;
		case 5:
			exitChoice = true;
			try {
				writeToFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			exitCall();
		default:
			System.out.println("Something unexpected has happened.");
		}
		
	}

	private static void addTune() {
		Scanner input = new Scanner(System.in);
		String song, album, author, genre;
		Rating rating;
		int length;
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
		System.out.print("What is the length of the song in seconds?: ");
		length = input.nextInt();
		newSong.setLength(length);
		
		//Creating Rating
		rating = new Rating();
		newSong.setFinalRating(rating);
		
		//Adding the tune
		tunes.add(newSong);
		System.out.println("\nAdded Song\n" + newSong.tuneToString());
		dotDelay(3);
	}
	
	private static void removeTune() {
		Scanner input = new Scanner(System.in);
		String songName;
		Tune tempTune;
		
		System.out.print("\nWhat song would you like to remove?: ");
		songName = input.nextLine();

		for (int i = 0; i <= tunes.size() -1 ; i++) {
			if (tunes.get(i).getSong().equals(songName)) {
				tempTune = tunes.get(i);
				tunes.remove(tunes.get(i));
				System.out.println("Removed a song!\n" + tempTune.tuneToString());
				return;
			}
		}
		System.out.println("Im sorry, the song is not found within the database.");
	}
	
	private void searchTunes() {
		Scanner input = new Scanner(System.in);
		String songName;
		Tune tempTune;
		
		System.out.print("\nWhat song would you like to search for more details?: ");
		songName = input.nextLine();
		
		for (int i = 0; i <= tunes.size() -1 ; i++) {
			if (tunes.get(i).getSong().equals(songName)) {
				tempTune = tunes.get(i);
				System.out.println("Showing Full Details\n" + tempTune.tuneToString());
				return;
			}
		}
		System.out.println("Im sorry, the searched song is not found within the database.");
	}
	
	private static void printTunes() {
			System.out.println("\nNow Printing All Tunes");
			tunes.printQuickTunes();
	}
	
	private void clearTunes() {
		System.out.print("Now clearing the entire database");
		dotDelay(3);
		tunes.clear();
	}

	//Gets user input to create a new Tune
	public int getMenuInput() {
		Scanner input = new Scanner(System.in);
		int choice = -1;
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
		
		for (int i = 0; i < tunes.size(); i++) {
			objOut.writeObject(tunes.get(i));	
		}
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
		System.out.println();
		
		TuneArray tempArray = new TuneArray();
		int count = 0;
		FileInputStream fileIn = new FileInputStream(filepath);
		try {
			@SuppressWarnings("resource")
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
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
		System.exit(0);
	}
	
	//Period Printing Thread Delay 
	public static void dotDelay(int totalDots) {
		for (int i = 0; i <= totalDots; i++) {
			try {
				Thread.sleep(950);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
	}	
}
