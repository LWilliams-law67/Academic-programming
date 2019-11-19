/**
 * This class tests the methods of the Golfer and Score classes.
 * 
 * @author spooky
 * @version 2.0
 * 
 * COP3022	Project 2
 * file name	GolferTester.java
 */

public class GolferTester
{
	public static void main(String [] args)
	{
		System.out.println("BEGIN TESTING :\n");

		System.out.println("\tGolfer (newPlayer) created.");
		Golfer newPlayer = new Golfer();

		System.out.print("\tnewPlayer.setName(Luke Williams) == ");
		newPlayer.setName("Luke Williams");
		System.out.print(newPlayer.getName() + "\n");

		System.out.print("\tnewPlayer.setHomeCourse(Lincoln Hills Golf Club) == ");
		newPlayer.setHomeCourse("Lincoln Hills Golf Club");
		System.out.print(newPlayer.getHomeCourse() + "\n");

		System.out.print("\tnewPlayer.getIDNum() == ");
		System.out.print(newPlayer.getIDNum() + "\n");

		System.out.print("\tnewPlayer.addScores(): ");
		newPlayer.addScores("Lincoln Hills Golf Club", 72, 69.4, 123, "05/18/19");
		newPlayer.addScores("A.C. Read", 77, 70.4, 128, "07/23/18");
		newPlayer.addScores("Bay Hill CC", 75, 69.5, 123, "06/03/19");
		System.out.println(newPlayer.toString() + "\n");
		
		System.out.println("\tnewPlayer.lowestScore() == " + newPlayer.lowestScore());
		System.out.println("\tnewPlayer.deleteScore(08/08/18) == " + newPlayer.deleteScore("08/08/18"));
		System.out.println("\tnewPlayer.deleteScore(07/23/18) == " + newPlayer.deleteScore("07/23/18"));
		System.out.println(newPlayer.toString() + "\n");
		
		System.out.println("TESTS COMPLETE");
		
		System.out.println();
		System.out.println("Golfer (newPlayer2) created with parameters (Alice Smith, Augusta National).");
		Golfer newPlayer2 = new Golfer("Alice Smith", "Augusta National");
		System.out.println("Using invlaid entries for newPlayer2 Score mutator methods...\n");
		newPlayer2.addScores("Augusta National", 210, 82.1, 160, "04/15/19");
		System.out.println(newPlayer2.toString() + "\n");

	}
}