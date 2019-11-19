/**
 * This class runs the methods to implement a TriviaGame.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 4
 * file name	TriviaGameTester.java
 */
//import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * The Class TriviaGameTester.
 */
public class TriviaGameTester {
	
	/** The junk input. */
	public static String junkInput; // to store '\n' characters after scnr.nextInt() statements.
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String playerName;
		String gamertag;
		File playerFile = null;
		Player playerOne = null;
		TriviaGame gameTime = new TriviaGame(playerOne);
		Admin manager = new Admin(scnr, gameTime);
		
		System.out.printf("%40s %-40s\n", "Welcome to", "Trivia Game!");
		
		int selection = 0;
		while (selection != 3) {
			System.out.printf(" 1. %s\n 2. %s\n 3. %s\n", "Play Game", "Manage Question", "Quit");
			System.out.println();
			System.out.print("Enter menu selection: ");
			selection = scnr.nextInt();
			junkInput = scnr.nextLine();			
			
			switch (selection) {
				case 1 :
					System.out.print("Are you a new player(y/n)? ");
					playerName = scnr.nextLine();
					playerName = playerName.toUpperCase();
					System.out.println();
					
					if (playerName.charAt(0) == 'Y') {
						System.out.print("Enter player name: ");
						playerName = scnr.nextLine();
						System.out.println();
						playerFile = new File(playerName + ".txt");
						if (!playerFile.exists()) {
							try {
								playerFile.createNewFile();
								System.out.println(playerName + " is a new player. New save file created.\n");
								System.out.print("Please Enter a new Gamertag: ");
								gamertag = scnr.nextLine();
								playerOne = new Player(playerFile, playerName, gamertag);
							} catch (IOException e) {
								System.out.println("Caught Exception: " + e.getMessage());
								continue;
							}
						}
						else {
							System.out.println(playerName + " already has an existing save file. Try again.\n");
							continue;
						}
					}
							
					else if (playerName.charAt(0) == 'N') {
						System.out.print("Enter player name: ");
						playerName = scnr.nextLine();
						System.out.println();
						playerFile = new File(playerName + ".txt");
						if (playerFile.exists())
							System.out.println(playerName + " is a returning player. Opening existing save file.\n");
						try {
							FileInputStream fs = new FileInputStream(playerFile);
							Scanner playerFS = new Scanner(fs);
							playerOne = new Player(playerFile, playerFS);
						} catch (IOException e) {
							System.out.println("Caught Exception: " + e.getMessage());
							System.out.println(playerName + "does not have an existing save file. Try again.\n");
							playerFile = null;
							continue;
						}
					}
					else {
						System.out.println("Invalid entry. Try again.");
						continue;
					}
					
					gameTime = new TriviaGame(playerOne);
					gameTime.play(scnr);
					selection = 0;
					break;
				case 2 :
					manager.menu();
					break;
				case 3 :
					break;
				default :
					System.out.println("Invalid menu option. Try again.");
			}
		}
	}
}

