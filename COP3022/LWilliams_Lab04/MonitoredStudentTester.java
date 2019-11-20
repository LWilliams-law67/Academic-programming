/**
 * This class runs the methods of the MonitoredStudent.java class.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab04
 * filename	MonitoredStudentTester.java
 */
import java.util.Scanner;
import java.lang.Integer;

public class MonitoredStudentTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String studentName;	//	A string to hold a student's name.
		String quizScore = " ";	//	A string to get quiz score input from user.
		int score;	//	An integer to parse the value of quizScore.
		String inputJunk = " ";	//	A string to hold the newline character from user input as necessary.
		String formatCols = "|%-20s|%-15s|%-15s|%n";	//	A string to format output columns.
		String formatRows = "|%-20s|%-15.0f|%-15.2f|%n";	//	A string to format output rows.


		System.out.print("Enter student's full name: ");
		studentName = input.nextLine();	//	Stores user's input for a student's name.
		System.out.print("\nWhat is the minimum passing average? ");
		score = input.nextInt();	//	Stores user's input for the minimum passing average.
		MonitoredStudent student = new MonitoredStudent(studentName, score);	//	Creates a Student object.
		
		while (Character.toUpperCase(quizScore.charAt(0)) != 'Q') {	//	A loop for inputting quiz scores.
			System.out.print("Please enter a quiz score (enter 'Q' to quit): ");
			quizScore = input.next();
			inputJunk = input.nextLine();	//	Discards '\n' symbol after user's input.
			
			if (quizScore.matches("^[0-9]*$")) {	//	Verifies that user's input is an integer value.
				try {
					score = Integer.parseInt(quizScore);	//	Parses the integer from the string.
				} catch (NumberFormatException e) {	//	catches an error if parsing does not work.
					score = -1;	//	sets the score value to -1 so that the score is ignored if parsing fails.
				}
				student.addQuiz(score);	//	Adds the quiz score to the Student's quizzes.
			}
			else if (quizScore.charAt(0) == 'Q' || quizScore.charAt(0) == 'q')
				break;	//	Breaks out of loop if the user wishes to 'Quit' entering scores.
			else
				System.out.println("Invalid score entry. Scores must be in the range 0-100.");	//	Prints error message if user's input is not an integer value.
		} System.out.println();
		
		System.out.printf(formatCols, "Student Name:", "Total Score:", "Average:");
		System.out.printf(formatRows, student.getName(), student.getTotalQuizScore(), student.getAverageScore());
		System.out.println("\nMinimum Passing Average: " + student.getMinPassingAvg());
		
		if (student.isOffProbation())	//	Checks if student is on/off academic probation.
			System.out.println(student.getName() + " is off academic probation.");
		else
			System.out.println(student.getName() + " is on academic probation.");
		
		System.out.println("\n\nUSING MONITOREDSTUDENT METHODS AFTER DEFAULT CONSTRUCTOR:");
		MonitoredStudent student2 = new MonitoredStudent();
		System.out.println("\tSETTING NEW MONITOREDSTUDENT NAME...");
		student2.setName("Michael Jackson");
		System.out.println("\tSETTING NEW MONITOREDSTUDENT MINIMUM PASSING AVERAGE...");
		student2.setMinPassingAvg(70);
		System.out.println("A new student has been added: " + student2.getName() + " with a minimum passing average of " + student2.getMinPassingAvg() + "." + inputJunk);		
		
		input.close();
	}

}
