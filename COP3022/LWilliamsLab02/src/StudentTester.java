/**
 * This class test the methods of the Student class
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab 02
 * file name:	StudentTester.java
 */
import java.util.Scanner;
import java.lang.Integer;

public class StudentTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String studentName;
		String quizScore = " ";
		int score;
		String inputJunk = " ";

		System.out.print("Enter student's full name: ");
		studentName = input.nextLine();
		Student student = new Student(studentName);
		
		while (Character.toUpperCase(quizScore.charAt(0)) != 'Q') {
			System.out.print("Please enter a quiz score (enter 'Q' to quit): ");
			quizScore = input.next();
			inputJunk = input.nextLine();
			
			if (quizScore.matches("^[0-9]*$")) {
				try {
					score = Integer.parseInt(quizScore);
				} catch (NumberFormatException e) {
					score = -1;
				}
				student.addQuiz(score);
			}
			else
				System.out.println("Invalid score entry. Scores must be in the range 0-100.");
		}
		
//		System.out.printf("%-20S" + "student name:" + "%-20S" + "total score:" + "%-20S %n" + "average");
//		System.out.printf("%20s" + student.getName() + "%20.0f" + student.getTotalQuizScore() + "%20.2f %n" + student.getAverageScore());
		
		System.out.printf("%-20S", "Student Name:");
		System.out.printf("%-20S", "Total Score:");
		System.out.printf("%-20S %n", "Average:");
		System.out.printf("%20s", student.getName());
		System.out.printf("%20.0f", student.getTotalQuizScore());
		System.out.printf("%20.2f %n", student.getAverageScore());
		
		System.out.println("\n\nTesting Student methods after default constructor.");
		Student student2 = new Student();
		System.out.println("Setting new Student name.");
		student2.setName("Michael Jackson");
		System.out.println("A new student has been added: " + student2.getName() + inputJunk);		
		
		input.close();
	}

}
