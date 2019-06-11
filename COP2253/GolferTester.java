/**
   COP2253 Java programming
   This is a class designed to test the Golfer and Score classes. This program calls the
   public member functions of the Golfer and Score classes and implements them together
   to ensure proper functionality.

   
   @author lwilliams
   @version 1.0
      COP2253 project 6
   filename: GolferTester.java
*/

import java.util.Scanner;

public class GolferTester
{
	public static void main(String [] args)
	{
		System.out.println("BEGIN TESTING :");

		System.out.println("\tgolfer (newPlayer) created.");
		Golfer newPlayer = new Golfer();

		System.out.print("\tnewPlayer.setName(Luke Williams) == ");
		newPlayer.setName("Luke Williams");
		System.out.print(newPlayer.getName());
		System.out.println();

		System.out.print("\tnewPlayer.setHomeCourse(Lincoln Hills Golf Club) == ");
		newPlayer.setHomeCourse("Lincoln Hills Golf Club");
		System.out.print(newPlayer.getHomeCourse());
		System.out.println();

		System.out.print("\tnewPlayer.getIDNum() == ");
		System.out.print(newPlayer.getIDNum());
		System.out.println();

		System.out.print("\tnewPlayer.addScores(Lincoln Hills Golf Club, 72, 69.4, 123, May 18 2018 == ");
		newPlayer.addScores("Lincoln Hills Golf Club", 72, 69.4, 123, "May 18 2018");
		System.out.print(newPlayer.getScore("May 18 2018").toString());
		System.out.println();

		System.out.println("TESTS COMPLETE");
	}
}