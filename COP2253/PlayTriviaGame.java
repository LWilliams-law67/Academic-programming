/**
   COP2253 Java programming
   This is a class designed to test the TriviaGame class by initiating a game of trivia.
   A file input stream is created and used to load the questions, answers, and values into an array.
   The user is asked to input the number of questions they wish to answer, and the game begins.
   Once the user decides not to play anymore the entire list of questions is printed to the screen.

   
   @author lwilliams
   @version 1.0
      COP2253 project 7
   filename: PlayTriviaGame.java
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class PlayTriviaGame
{
	public static void main(String [] args) throws IOException
	{
		FileInputStream fis = null;
		//Attempting to open file.
		fis = new FileInputStream("questions.dat");

		TriviaGame newGame = new TriviaGame(fis);

		Scanner sc = new Scanner(System.in);

		System.out.println("TRIVIA TIME!");
		int numberOfQuestions = 0;
		String playAgain = "yes";
		char playAgainLetter = playAgain.charAt(0);		
		do
		{
			while (numberOfQuestions < 1 || numberOfQuestions > 10)
			{
				System.out.print("How many questions would you like to guess (1 to 10 inclusive)? ");
				numberOfQuestions = sc.nextInt();
				System.out.println();

				if (numberOfQuestions < 1 || numberOfQuestions > 10)
					System.out.println("The specified value is out of range.");
			}
			
			newGame.play(numberOfQuestions);
			System.out.println("Game Over.\nYour completed score is: " + newGame.getScore());
			System.out.print("Would you like to play again (yes or no)? ");
			playAgain = sc.next();
			System.out.println();

			playAgainLetter = playAgain.charAt(0);

		} while (playAgainLetter != 'n');

		System.out.println(newGame.toString());

		fis.close();
	}
}