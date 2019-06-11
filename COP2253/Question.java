/**
   COP2253 Java programming
   This is a class designed to hold the members and methods of a 'Question' object for a trivia game.
   The 'Question' object will have a String for the 'question' to be asked, and the 'answer' to 
   that 'question'. Also, an integer 'value' will hold the level of difficulty for the specific 'question'
   object. This 'value' must be 1 to 5 inclusive.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 7
   filename: Question.java
*/

import java.util.Scanner;

public class Question
{
	//Constant used as a default value for question difficulty if the input value is out of the required range.
	static final int INVALIDVALUE = -1;

	private String question;
	private String answer;
	private int value;

	//Simple constructors that call the mutator methods.
	public Question()
	{
		setQuestion("");
		setAnswer("");
		setValue(INVALIDVALUE);
	}

	public Question(String question, String answer, int value)
	{
		setQuestion(question);
		setAnswer(answer);
		setValue(value);
	}

	//Simple mutator methods for setting the private member values.
	public void setQuestion(String question)
	{
		this.question = question;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public void setValue(int value)
	{
		if (value < 1 || value > 5)
		{
			System.out.println("The specified question value is not within the required range (1 to 5 inclusive).\nThe value will be set to -1.");
			this.value = INVALIDVALUE;
			return;
		}
		this.value = value;
	}

	//Accessor methods for retrieving the private members outside of this class.
	public String getQuestion()
	{
		return this.question;
	}

	public String getAnswer()
	{
		return this.answer;
	}

	public int getValue()
	{
		return this.value;
	}

	//A toString() function for outputting the private member values as a single string (one value per line).
	public String toString()
	{
		return this.question + "\n" + this.answer + "\n" + this.value + "\n\n";
	}
}