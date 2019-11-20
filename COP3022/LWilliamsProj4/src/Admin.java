/**
 * This class stores the information and methods for trivia game administration.
 * This class allows manipulation of the question bank through text menu options.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 4
 * file name	Admin.java
 */
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Class Admin.
 */
public class Admin {
	
	/** The selection. */
	private int selection;
	
	/** The out FS. */
	private PrintWriter outFS;
	
	/** The scnr. */
	private Scanner scnr;
	
	/** The curr game. */
	TriviaGame currGame;
	
	/**
	 * Instantiates a new admin.
	 *
	 * @param scnr the scnr
	 * @param currGame the curr game
	 */
	public Admin(Scanner scnr, TriviaGame currGame) {
		selection = 0;
		this.scnr = scnr;
		this.currGame = currGame;
	}
	
	/**
	 * Menu.
	 */
	public void menu() {
		String menu = String.format("\n\t\t1: %-20s \n\t\t2: %-20s \n\t\t3: %-20s \n\t\t4: %-20s \n\t\t5: %-20s\n", "List all questions", "Add question", "Delete question", "Find question", "Quit");
		while (selection != 5) {
			System.out.println(menu);
			System.out.print("\t\tEnter option: ");
			selection = scnr.nextInt();
			TriviaGameTester.junkInput = scnr.nextLine();
			
			switch (selection) {
			case 1 :
				listQuestions();
				break;
			case 2 :
				addQuestion();
				break;
			case 3 :
				deleteQuestion(currGame);
				break;
			case 4 :
				String idToFind = "";
				System.out.printf("\t\t%s", "Enter question ID to find: ");
				idToFind = scnr.nextLine();
				findQuestion(idToFind, currGame);
				break;
			case 5 :
				break;
			default :
				System.out.println("\t\tThat is not a valid menu option. Try again.");
			}
		}
		selection = 0;
	}
	
	/**
	 * List questions.
	 */
	public void listQuestions() {
		try {
			FileInputStream fileIn = new FileInputStream("questions.txt");
			Scanner inputFile = new Scanner(fileIn);
			while (inputFile.hasNextLine()) {
				System.out.print("\t\t\t");
				System.out.println(inputFile.nextLine());
			}
			inputFile.close();
		} catch (IOException e) {
			System.out.println("\t\t\tCaught Exception: " + e.getMessage());
		}
	}
	
	/**
	 * Adds the question.
	 */
	public void addQuestion() {
		try {
			FileOutputStream fileOut = new FileOutputStream("questions.txt", true);
			outFS = new PrintWriter(fileOut);
		} catch (IOException e) {
			System.out.println("\t\t\tCaught Exception: " + e.getMessage());
		}
		
		String text = "A\n";
		System.out.println("\t\t\tNew questions are automatically set to active.");
		
		System.out.print("\t\t\tEnter question ID: ");
		text += scnr.nextLine();
		text += " ";
		text += "\n";
		
		System.out.println();
		System.out.print("\t\t\tEnter question: ");
		text += scnr.nextLine();
		text += "\n";
		
		System.out.println();
		System.out.print("\t\t\tEnter answer: ");
		text += scnr.nextLine();
		text += "\n";
		
		int value = 0;
		while (value < 1 || value > 5) {
			try {
				System.out.println();
				System.out.print("\t\t\tEnter point value: ");
				value = scnr.nextInt();
				TriviaGameTester.junkInput = scnr.nextLine();
				checkValue(value);
			} catch (InvalidValueException e) {
				System.out.println(e.message());
				System.out.println("\t\t\tQuestion value must be 1 - 5 inclusive.");
			}	
		}
		text += value;
		text += "\n";
		
		outFS.append(text);
		outFS.close();
		currGame.loadQuestions();
	}
	
	/**
	 * Check value.
	 *
	 * @param value the value
	 * @throws InvalidValueException the invalid value exception
	 */
	public void checkValue(int value) throws InvalidValueException {
		if (value < 1 || value > 5)
			throw new InvalidValueException("Integer out of bounds.");
	}
	
	/**
	 * Delete question.
	 *
	 * @param currGame the curr game
	 */
	public void deleteQuestion(TriviaGame currGame) {
		System.out.print("\t\tEnter the question ID to be deleted: ");
		String id = scnr.nextLine();
		Question found = findQuestion(id, currGame);
		if (found != null)
			found.setActivated("D");
		else {
			System.out.println("\t\tUnable to find question ID " + id);
			return;
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("questions.txt", false);
			PrintWriter overwriteFile = new PrintWriter(fileOut);
			String fileText = "";
			for (int i = 0; i < currGame.getGameQuestions().size(); i++) {
				if (currGame.getGameQuestions().get(i).getActivated())
					fileText += "A\n";
				else
					fileText += "D\n";
				
				fileText += currGame.getGameQuestions().get(i).getQuestionID();
				fileText += "\n";
				fileText += currGame.getGameQuestions().get(i).getQuestion();
				fileText += "\n";
				fileText += currGame.getGameQuestions().get(i).getAnswer();
				fileText += "\n";
				fileText += currGame.getGameQuestions().get(i).getValue();
				fileText += "\n";
			}
			overwriteFile.print(fileText);
			overwriteFile.close();
			currGame.loadQuestions();
		} catch (IOException e) {
			System.out.println("\t\t\tCaught Exception: " + e.getMessage());
		}
	}
	
	/**
	 * Find question.
	 *
	 * @param idToFind the id to find
	 * @param currGame the curr game
	 * @return the question
	 */
	public Question findQuestion(String idToFind, TriviaGame currGame) {
		idToFind += " ";
		for (int i = 0; i < currGame.getGameQuestions().size(); i++) {
			if (currGame.getGameQuestions().get(i).getQuestionID().equalsIgnoreCase(idToFind)) {
				System.out.printf("\t\t%s", "Question found!");
				System.out.println();
				return currGame.getGameQuestions().get(i);
			}
		}
		System.out.printf("\t\t%s", "Question not found.");
		System.out.println();
		return null;
	}
}
