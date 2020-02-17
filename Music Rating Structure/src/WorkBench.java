import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkBench {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		
		//Instance Variables
		String enter;
		
		//Main Menu
		printMainMenu();
		
		//Input validation for entering the Music Rating Database
		do {
		    System.out.print("What would you like to do[1-4]?: ");
		    enter = input.nextLine().toLowerCase();
		}
		while (!"1".equals(enter) && !"2".equals(enter) && !"3".equals(enter) && !"4".equals(enter));
		
		//Array for Songs
		TuneArray mainArray = new TuneArray();
		
		//New Setup
		if (enter.equals("1")) {
			introduction();
			Tune newTune = userInputTune(input);
			mainArray.add(newTune);
			writeToFile(mainArray);
			
			System.out.println("Congrats! Your first song is in the database under the file myDatabase.bin!");
			
		//Quick Start
		} else if (enter.equals("2")) {
			System.out.print("Please enter file path to myDatabase.bin: ");
			String filepath = input.next();
			mainArray = importFromFile(filepath);
			
		//About
		} else if (enter.equals("3")) {
			//TODO Finish The About
			
		//Exit
		} else if (enter.equals("4")) {
			System.out.print("Well, I hope to see you soon! Now Exiting");
			for (int i = 0; i <= 2; i++) {
				Thread.sleep(950);
				System.out.print(".");
			}
			System.exit(0);
		}
		
		String filepath = "myDatabase.bin";
		
		TuneArray tempArray = new TuneArray();
		tempArray = importFromFile(filepath);
		
		for (int i = 0; i < tempArray.size(); i++) {
			mainArray.add(tempArray.get(i));
		}
		System.out.println("Can we get to here");
		mainArray.printQuickTunes();
		
	}
	
	public static void introduction() {
		System.out.println("\nWelcome to your personal music rating database!");
		System.out.println("Well have you start by rating your first song!");

	}
	
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
	
	public static void writeToFile(TuneArray array) throws IOException {
		FileOutputStream out = new FileOutputStream("myDatabase.bin");
		
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		objOut.write(array.size());
		
		for (int i = 0; i < array.size(); i++) {
			objOut.writeObject(array.get(i));	
		}
		
		objOut.close();
	}
	
	public static TuneArray importFromFile(String filepath) {
		TuneArray tempArray = new TuneArray();
		int count;
		try {
			 
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			count = objectIn.readInt();
			
			for (int i = 0; i < count; i++) {
				System.out.println("Trial");
				Tune obj = (Tune) objectIn.readObject();
				tempArray.add(obj);
				System.out.println("Object " + (i+1) + ": " + obj.tuneToString());
			}
           
           
           objectIn.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return tempArray;
	}
}
