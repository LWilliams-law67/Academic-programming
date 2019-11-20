/**
 * This class reads integers from a file that represent grades.
 * Then calculates the average grade rounded to two decimal places.
 *
 * @author spooky
 * @version 1.0
 *
 * COP3320	Lab07
 * file name	AvgGrades.java
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AvgGrades {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		FileInputStream gradeFile = null;
		Scanner inFile = null;
		int grade = 0;
		int total = 0;
		int numGrades = 0;
		double avgGrade = 0.0;
		try {
			gradeFile = new FileInputStream("grades.dat");
			inFile = new Scanner(gradeFile);
		}
		catch (FileNotFoundException e) {
			System.out.println("Caught Exception: " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Grades:");
		while (inFile.hasNext()) {
			grade = inFile.nextInt();
			System.out.println(grade);

			total += grade;
			numGrades++;
		}

		avgGrade = ((double)total) / numGrades;
		int temp = (int)(avgGrade * 100);
		avgGrade = ((double)temp) / 100;

		String message = String.format("Total Grade Score: %-10d # of Grades: %-10d\nAverage Grade: %-10.2f", total, numGrades, avgGrade);
		System.out.println(message);

		inFile.close();

	}

}
