/**
 * This class stores the instance variables and methods for a Student's quiz scores
 * and provides a means to get the average.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab 02
 * file name: Student.java
 */
public class Student {
	private String name;
	private double totalQuizScore;
	private int numQuizzesTaken;
	
	/**
	 * Sets default values for instance variables
	 */
	public Student() {
		this.name = "No Name Provided";
		this.totalQuizScore = 0.0;
		this.numQuizzesTaken = 0;
	}
	
	/**
	 * @param name of the Student
	 */
	public Student(String name) {
		this.name = name;
		this.totalQuizScore = 0.0;
		this.numQuizzesTaken = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the totalQuizScore
	 */
	public double getTotalQuizScore() {
		return totalQuizScore;
	}

	/**
	 * @param totalQuizScore the totalQuizScore to set
	 */
	public double getAverageScore() {
		return totalQuizScore / numQuizzesTaken;
	}

	/**
	 * @param numQuizzesTaken the numQuizzesTaken to set
	 */
	public void addQuiz(int score) {
		if (score < 0 || score > 100) {
			System.out.println("Invalid score entry.");
			return;
		}
		
		this.numQuizzesTaken++;
		this.totalQuizScore += score;
	}

//	@Override
//	public String toString() {
//		return String.format("Student [name=%s, totalQuizScore=%s, numQuizzesTaken=%s, getAverageScore()=%s]", name,
//				totalQuizScore, numQuizzesTaken, getAverageScore());
//	}

}
