/**
   COP2253 Java programming
   This program takes input from a user; such as, beginning balance, interest rate,
   and the number of yearly quarters; then, displays the balances of the account
   with the information provided. The number of quarters is limited to 1-10 inclusive,
   interest is limited to 1-20 percent inclusive, and the beginning balance must be
   greater than zero.

   Formula used to calculate the account balance:
   		B + [B * (R/100) * .25] where B is the beginning balance and R is the interest rate.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 3
   filename: InterestCalculator.java
*/

import java.util.Scanner;

public class InterestCalculator
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);	//	Scanner method for extracting user input
		int numQuarters;
		double startBalance, interestRate, interestEarned, endBalance;

		// Takes input from user for the account starting balance
		System.out.print("Please provide the beginning account balance: ");
		startBalance = input.nextDouble();

		// A loop to verify the starting balance input is valid
		do
		{
			System.out.println("\nThe starting balance must be greater than zero.");
			System.out.print("Please try another starting balance: ");
			startBalance = input.nextDouble();

		}while (startBalance < 0);

		// Takes input from user for the number of quarters to calculate an ending balance
		System.out.print("\nHow many quarters do you wish to calculate the ending account balance? ");
		numQuarters = input.nextInt();

		// A loop to verify the number of quarters is valid
		do
		{
			System.out.println("\nThe number of quarters must be between 1 and 10 inclusive.");
			System.out.print("Number of quarters to calculate balance: ");
			numQuarters = input.nextInt();

		}while (numQuarters < 1 || numQuarters > 10);

		// Takes input from user for the interest rate on the account
		System.out.println("\nPlease provide the interest rate of the account:");
		interestRate = input.nextDouble();

		// A loop to verify the interest rate is valid
		do
		{
			System.out.println("\nThe interest rate must be between 1 and 20 inclusive.");
			System.out.print("Provide the interest rate on the account: ");
			interestRate = input.nextDouble();

		}while (interestRate < 1 || interestRate > 20);




	}
}