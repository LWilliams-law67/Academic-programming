/**
   COP2253 Java programming
   This is a class designed to implement the functinality of a trivia game.
   The private member 'gameQuestions[]' holds up to 10 Question objects and calls the Question methods
   to ask a user a specific number of questions, take the user's answer, and then compare
   that answer with the correct Question answer. The user's score is updated according to
   correct responses.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 7
   filename: TriviaGame.java
*/

import java.util.Scanner;
import java.io.FileInputStream;

public class TriviaGame
{
	private Question[] gameQuestions;
	private int score;
	private int numberOfQuestions;
	private int currentQuestion;

	//A constructor that takes in a FileInputStream object and parses the file to create Question objects.
	public TriviaGame(FileInputStream fisObject)
	{
		Scanner scnr = new Scanner(fisObject);
		this.numberOfQuestions = 0;
		this.currentQuestion = 0;
		this.gameQuestions = new Question[10];

		//Loop iterates through the FileInputStream object and uses a Scanner object to extract
		//a line at a time. 'currentQuestion' member is used to iterate through 'gameQuestions[]'
		//then 'currentQuesiton' is set back to zero. 'numberOfQuestions' is used to track the total
		//number of Question objects being pulled from the file.
		while (scnr.hasNextLine())
		{
			String q = scnr.nextLine();
			String a = scnr.nextLine();;
			int v = Integer.parseInt(scnr.nextLine());

			gameQuestions[currentQuestion] = new Question(q, a, v);

			this.numberOfQuestions++;
			this.currentQuestion++;
			if (this.currentQuestion >= 10)
				break;
		}
	}

	//Simple accessor methods for the private members.
	public int getScore()
	{
		return this.score;
	}

	public int getNumberOfQuestions()
	{
		return this.numberOfQuestions;
	}

	public int getCurrentQuestion()
	{
		return this.currentQuestion;
	}

	//play() is a method to implement the functionality of the TriviaGame class to a user.
	public void play(int numOfQuestionsToAsk)
	{
		Scanner input = new Scanner(System.in);
		String userAnswer = "";
		this.score = 0;
		this.currentQuestion = 0;

		//A loop to iterate through the 'numOfQuestionsToAsk'
		while (numOfQuestionsToAsk > 0)
		{
			//Ask the user the next question, and get their answer.
			System.out.println(nextQuestion());
			userAnswer = input.next();
			input.nextLine();

			//Checks the user's answer for correctness and adjusts the user's score if needed.
			if (evaluateAnswer(userAnswer))
			{
				this.score += gameQuestions[currentQuestion].getValue();
				numOfQuestionsToAsk--;
				continue;
			}
			else
			{
				numOfQuestionsToAsk--;
				continue;
			}
		}
	}

	//Returns a String of the next question to ask the user using the 'currentQuestion' member to access 'gameQuestions[]'.
	public String nextQuestion()
	{
		return gameQuestions[currentQuestion].getQuestion();
	}

	//Compares 'userAnswer' to the Question object 'answer' and returns 'true' if correct or 'false' if incorrect.
	public boolean evaluateAnswer(String userAnswer)
	{
		String ans = gameQuestions[currentQuestion].getAnswer();

		//Increments the private member 'currentQuestion' for the implementation of the game.
		this.currentQuestion++;

		//Exits and returns false if 'userAnswer' is shorter or longer than the actual answer.
		if (ans.equals(userAnswer))
			return true;

		// for (int i = 0; i < ans.length(); i++)
		// {
		// 	if (userAnswer.charAt(i) != ans.charAt(i))
		// 		return false;
		// }

		else
			return false;
	}

	//Calls the 'Question toString()' method for each question in the gameQuestions array.
	public String toString()
	{
		String allQuestions = "";
		for (currentQuestion = 0; currentQuestion < numberOfQuestions; currentQuestion++)
		{
			allQuestions = allQuestions + "Question " + (currentQuestion + 1) + ":\n" + gameQuestions[currentQuestion].toString();
		}

		return allQuestions;
	}
}