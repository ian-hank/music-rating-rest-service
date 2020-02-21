import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkBench {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		
		//Constant Variables
		final String FILE_PATH = "myDatabase.bin";
		
		//Instance Variables
		String menuChoice, currentChoice;
		TuneArray mainArray = new TuneArray();
		
		//Main Menu
		printMainMenu();
		
		//Input validation for entering the Music Rating Database
		do {
		    System.out.print("What would you like to do[1-4]?: ");
		    menuChoice = input.nextLine().toLowerCase();
		}
		while (!"1".equals(menuChoice) && !"2".equals(menuChoice) && !"3".equals(menuChoice) && !"4".equals(menuChoice));
		
		//New Setup
		if (menuChoice.equals("1")) {
			System.out.println("\nWelcome to your personal music rating database!");
			System.out.println("Well have you start by rating your first song!");
			Tune newTune = userInputTune(input);
			mainArray.add(newTune);
			mainArray.add(newTune);
			mainArray.add(newTune);
			mainArray.add(newTune);
			writeToFile(mainArray);
			
			System.out.println("\nCongrats! Your first song is in the database under the file myDatabase.bin!"
					+ "\nWe will now enter the main screen for manipulating your tunes!");
			
		//Quick Start
		} else if (menuChoice.equals("2")) {
			System.out.println("Importing all Tunes to array!");
			TuneArray tempArray = importFromFile(FILE_PATH);
			
			for (int i = 0; i < tempArray.size(); i++) {
				mainArray.set(i, tempArray.get(i));
			}
			
		//About
		} else if (menuChoice.equals("3")) {
			//TODO Finish The About
			System.out.println("Yea we will finish it eventually!");
			
		//Exit
		} else if (menuChoice.equals("4")) {
			exitCall();
		}
		
		printOverallMenu();
		
		do {
			System.out.println("Please enter 6 for Menu! ");
			System.out.print("Please enter a number--> ");
			currentChoice = input.nextLine();
			
			if (currentChoice.equals("1")) {
				Tune newTune = userInputTune(input);
				mainArray.add(newTune);
			} else if (currentChoice.equals("2")) {
				System.out.print("\nWhat do you want to remove?: ");
				String songName = input.nextLine();
				
				for (int i = 0; i < mainArray.size(); i++) {
					if (mainArray.get(i).getSong() == songName) {
						System.out.println("Removing " + mainArray.get(i).getSong());
						mainArray.remove(mainArray.get(i));
						break;
					}
				}
			} else if (currentChoice.equals("3")) {
				System.out.println("Search for Tune Details By Song Name: ");
				String songName = input.nextLine();
				for (int i = 0; i < mainArray.size(); i++) {
					if (mainArray.get(i).getSong() == songName) {
						System.out.println("Details:\n\n " + mainArray.get(i).tuneToString());
						break;
					}
				}
			} else if (currentChoice.equals("4")) {
				exitCall();
			} else if (currentChoice.equals("5")) {
				mainArray.printQuickTunes();
				System.out.println("\n");
			} else if (currentChoice.equals("6")) {
				printOverallMenu();
			} else {
				System.out.println("\nSorry I Couldnt Understand Your Answer!");	
			}
			
		} while (!currentChoice.equals("4"));
		
		
		
	}
	//Prints the changes menu
		public static void printOverallMenu() {
			System.out.println("\n _______________________");
			System.out.println("| Music Rating Database |");
			System.out.println("|                       |");
			System.out.println("|      --Options--      |");
			System.out.println("|                       |");
			System.out.println("|1: Add New Tune        |");
			System.out.println("|2: Remove Tune         |");
			System.out.println("|3: Get Tune(Index)     |");
			System.out.println("|4: Exit --> Save/Write |");
			System.out.println("|5: Print Quick View    |");
			System.out.println("|_______________________|");
		}
	//Prints the Main Menu
		public static void printMainMenu() {
			System.out.println(" ________________________");
			System.out.println("| Music Rating Database  |");
			System.out.println("|                        |");
			System.out.println("|      Version 1.0       |");
			System.out.println("|                        |");
			System.out.println("|                        |");
			System.out.println("|      By: Ian Hank      |");
			System.out.println("|                        |");
			System.out.println("|     1: New Setup       |");
			System.out.println("|     2: Quick Start     |");
			System.out.println("|     3: About           |");
			System.out.println("|     4: Exit            |");
			System.out.println("|________________________|");
		}
		
	//Gets user input to create a new Tune
	public static Tune userInputTune(Scanner input) {
		String song, album, author, genre;
		Rating rating;
		int length;
		
		Tune newSong = new Tune();
		
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
		
		rating = new Rating();
		newSong.setFinalRating(rating);
		return newSong;
	}
	
	//Writes Tunes to a binary file
	public static void writeToFile(TuneArray array) throws IOException {
		FileOutputStream out = new FileOutputStream("myDatabase.bin");
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		for (int i = 0; i < array.size(); i++) {
			objOut.writeObject(array.get(i));	
		}
		Tune endTune = new Tune();
		endTune.setLength(-1);
		objOut.writeObject(endTune);
		
		objOut.close();
	}
	
	//Imports Tunes from binary file
	public static TuneArray importFromFile(String filepath) throws FileNotFoundException {
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
	public static void exitCall() throws InterruptedException {
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
