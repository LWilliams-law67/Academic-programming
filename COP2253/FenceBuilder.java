/**
   COP2253 Java programming
   This program draws a Fence. The pound sign (#) is used for the outline of the fence
   and the pipe character (|) is used for the fence bars. A static variable (fenceCount) keeps
   track of the amount of fence objects created in a single run of this program.
   This file provides the instruction and methods for the user to define the parameters of a Fence,
   and implements the building of a Fence object.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 5
   filename: FenceBuilder.java
*/

import java.util.Scanner;

public class FenceBuilder
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		Fence fenceObj = new Fence();
		int userHeight = 0;
		int userWidth = 0;

		char buildAgain = 'y';
		do {
			//	Gets userHeight value from input and ensures the input is in a specific range.
			while (userHeight < 2 || userHeight > 5) {
				System.out.print("Enter the height in range [2,5]: ");
				userHeight = input.nextInt();

				if (userHeight < 2 || userHeight > 5) {
					System.out.println("\nThe height must be between 2 and 5 inclusive.\n");
				}
			}
			//	Set fenceObj height to the value of userHeight.
			fenceObj.setHeight(userHeight);

			//	Gets userWidth value from input and ensures the input is in a specific range.
			while (userWidth < 3 || userWidth > 24) {
				System.out.print("Enter the width in range [3, 24]: ");
				userWidth = input.nextInt();
				System.out.println("");

				if (userWidth < 3 || userWidth > 24) {
					System.out.println("The width must be between 3 and 24 inclusive.\n");
				}
			}
			//	Set fenceObj width to the value of userWidth.
			fenceObj.setWidth(userWidth);
			//	Outputs the fence drawing using the user specified dimensions.
			fenceObj.draw();

			//	Asks user to build another fence and if so, resets the height and width values to zero.
			System.out.print("Would you like to build another fence? [y, n]: ");
			buildAgain = input.next().charAt(0);
			if (buildAgain == 'y' || buildAgain == 'Y') {
				userHeight = 0;
				userWidth = 0;
			}
			System.out.println("");

		}while (buildAgain == 'y' || buildAgain == 'Y');

		//	Tells the user how many fences they built.
		System.out.println("You built " + fenceObj.getFenceCount() + " fence(s).\n");
	}
}