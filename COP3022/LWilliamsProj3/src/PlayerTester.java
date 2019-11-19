/**
 * This class has the main arguments to test the abstract Player class, as well as
 * the Golfer and Bowler derived classes.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 3
 * file name	PlayerTester.java
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The Class PlayerTester.
 */
public class PlayerTester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Golfer> golfers = new ArrayList<>();
		ArrayList<Bowler> bowlers = new ArrayList<>();
		Scanner inFile = null;
		String numScores = "";
		char playerType = 'g';
		String name = "";
		String team = "";
		String place = "";
		String score = "";
		String date = "";
		String rating = "";
		String slope = "";
		Player[] players = new Player[10];
		
		System.out.println("Opening file data.txt");
		try {
			inFile = new Scanner(new FileInputStream("data.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Caught Exception: " + e.getMessage());
			System.exit(0);
		}
		
		inFile.useDelimiter(",|\r\n");
		int i = 0;
		int currGolfer = 0;
		int currBowler = 0;
		while (inFile.hasNextLine()) {
			numScores = inFile.next();
			playerType = inFile.next().toLowerCase().charAt(0);
				
			if (playerType == 'g') {
				name = inFile.next();
				place = inFile.next();
					
				golfers.add(new Golfer(name, place));
				
				
				for (int j = 0; j < Integer.parseInt(numScores); j++) {
					place = inFile.next();
					score = inFile.next();
					date = inFile.next();
					rating = inFile.next();
					slope = inFile.next();
					golfers.get(currGolfer).addScores(new Course(place, Double.parseDouble(rating), Integer.parseInt(slope)), Integer.parseInt(score), date);
				}
				players[i] = golfers.get(currGolfer);
				i++;
				currGolfer++;
			}
			
			else {
				name = inFile.next();
				team = inFile.next();
					
				bowlers.add(new Bowler(name, team));
				
				
				for (int j = 0; j < Integer.parseInt(numScores); j++) {
					place = inFile.next();
					score = inFile.next();
					date = inFile.next();
					bowlers.get(currBowler).addScores(new BowlerScore(place, Integer.parseInt(score), date));
				}
				players[i] = bowlers.get(currBowler);
				i++;
				currBowler++;
			}
		}
		
		for (int j = 0; j < i; j++)
			System.out.println(players[j].toString());
	}

}
