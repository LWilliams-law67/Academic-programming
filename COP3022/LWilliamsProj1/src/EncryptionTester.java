/**
 * This class tests the Encryption class and its methods.
 * 
 * @author spooky
 * @version 1.0
 *
 *COP3022    Project #: 1
 *File Name: EncryptionTester.java
 */
import java.util.Scanner;
import java.util.Random;

public class EncryptionTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userKey = 0;
		String userPassword = "";
		String junkFromInput = "";
		
		char runProgramAgain;
		do {
			
			while (userPassword.length() < 8) {
				System.out.println("Please create an 8 digit password using letters, numbers, and special characters (!@#$%^&*-+][;:'/?.,<>)");
				userPassword = input.next();
				junkFromInput = input.nextLine();
				if (userPassword.length() < 8)
					System.out.println("The password must be at least 8 characters long, your password is only " + userPassword.length() + " characters long.");
			}
			
			while (userKey < 1 || userKey > 10) {
				System.out.println("\nPlease enter a key for password encryption (1 - 10 inclusive): ");
				userKey = input.nextInt();
				junkFromInput = input.nextLine();
				if (userKey < 1 || userKey > 10)
					System.out.println("The key must be between 1 and 10, you entered " + userKey + ".");
			}
			System.out.println("");
			
			Encryption data1 = new Encryption();
			Encryption data2 = new Encryption(userKey, userPassword);
			System.out.println("Two Encryption objects have been created. One without values, and the second with your input.");
			
			System.out.println("\nYour input has been stored as follows:");
			System.out.println(data2.toString());
			
			Random rand = new Random(); // to randomize the testKey.
			int testKey = rand.nextInt(10);
			System.out.println("\nTesting the setPassword function with a string \"Testing\"");
			data1.setPassword(testKey, "Testing"); // to test the setPassword method from default constructor.
			System.out.println(data1.toString());
			System.out.println("");
			
			String loginPassword;
			boolean loginSuccessful = false;
			while (!loginSuccessful) {
				System.out.println("Please provide your password for verification: ");
				loginPassword = input.next();
				junkFromInput = input.nextLine();
				
				loginSuccessful = data2.isValidPassword(loginPassword);
				if (loginSuccessful)
					System.out.println("Password verified.");
				else
					System.out.println("Invalid entry. Try again.");
			}
			
			System.out.println("\nWould you like to run the program again (y or n)? ");
			runProgramAgain = Character.toUpperCase(input.next().charAt(0));
			junkFromInput = input.nextLine();
			
			System.out.println(junkFromInput); // puts the \n character from all the user input to use by separating multiple runs of the program.
		}while (runProgramAgain == 'Y');
		
		input.close();
	}
}
