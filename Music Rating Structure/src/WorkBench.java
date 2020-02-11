import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkBench {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println(" ________________________");
		System.out.println("| Music Rating Database  |");
		System.out.println("|                        |");
		System.out.println("|      Version 1.0       |");
		System.out.println("|                        |");
		System.out.println("|                        |");
		System.out.println("|      By: Ian Hank      |");
		System.out.println("|                        |");
		System.out.println("|________________________|");
		String enter;
		do {
			System.out.print("\nWould you like to enter? (Yes or No): ");
		    enter = input.next().toLowerCase();
		    
		} while (enter != "yes");
		
		if (enter == "no") {
			System.out.println("Sorry to see you go now exiting...");
		}

		
	}
	
	public void introduction() {
		System.out.println("Welcome to your personal music rating database!");
		System.out.println("Do you happen to have a compatible file to begin");
		System.out.print("managing your database of music? (Yes or No): ");

	}
}
