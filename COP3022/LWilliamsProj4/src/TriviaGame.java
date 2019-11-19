/**
 * This class implements a Trivia Game. Reads data from a question bank file,
 * then stores and uses methods to ask the player questions.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 4
 * file name	TriviaGame.java
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

/**
 * The Class TriviaGame.
 */
public class TriviaGame {
	
	/** The game questions. */
	private ArrayList<Question> gameQuestions;
	
	/** The fs. */
	private FileInputStream fs;
	
	/** The q FS. */
	private Scanner qFS;
	
	/** The curr question index. */
	private int currQuestionIndex;
	
	/** The curr player. */
	private Player currPlayer;
	
	/** The curr game score. */
	private int currGameScore;
	
	/**
	 * Instantiates a new trivia game.
	 */
	public TriviaGame() {
		loadQuestions();
		setCurrQuestionIndex(getNextIndex());
		currPlayer = new Player(new File("PlayerOne.txt"), "John Doe", "Player One");
		currGameScore = 0;
	}
	
	/**
	 * Instantiates a new trivia game.
	 *
	 * @param currPlayer the curr player
	 */
	public TriviaGame(Player currPlayer) {
		loadQuestions();
		setCurrQuestionIndex(getNextIndex());
		setCurrPlayer(currPlayer);
		currGameScore = 0;
	}
	
	/**
	 * Gets the game questions.
	 *
	 * @return the game questions
	 */
	public ArrayList<Question> getGameQuestions() {
		return gameQuestions;
	}
	
	/**
	 * Gets the curr question index.
	 *
	 * @return the curr question index
	 */
	public int getCurrQuestionIndex() {
		return currQuestionIndex;
	}
	
	/**
	 * Gets the curr game score.
	 *
	 * @return the curr game score
	 */
	public int getCurrGameScore() {
		return currGameScore;
	}
 	
	/**
	 * Sets the curr question index.
	 *
	 * @param currQuestionIndex the new curr question index
	 */
	public void setCurrQuestionIndex(int currQuestionIndex) {
		this.currQuestionIndex = currQuestionIndex;
	}
	
	/**
	 * Sets the curr player.
	 *
	 * @param currPlayer the new curr player
	 */
	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}
	
	/**
	 * Load questions.
	 */
	public void loadQuestions() {
		gameQuestions = new ArrayList<Question>();
		try {
			fs = new FileInputStream("questions.txt");
			qFS = new Scanner(fs);
		} catch (Exception e) {
			System.out.println("Caught Exception: " + e.getMessage());
		}
		String activated = "";
		String questionID = "";
		String question = "";
		String answer = "";
		int value = 0;
		while (qFS.hasNextLine()) {
			activated = qFS.nextLine();
			questionID = qFS.nextLine();
			question = qFS.nextLine();
			answer = qFS.nextLine();
			value = qFS.nextInt();
			TriviaGameTester.junkInput = qFS.nextLine();
			
			gameQuestions.add(new Question(activated, questionID, question, answer, value));
		}
	}
	
	/**
	 * Gets the next index.
	 *
	 * @return the next index
	 */
	public int getNextIndex() {
		Random rand = new Random();
		currQuestionIndex = rand.nextInt(gameQuestions.size());
		while (!gameQuestions.get(currQuestionIndex).getActivated()) {
			currQuestionIndex = rand.nextInt(gameQuestions.size());
		}
		return currQuestionIndex;
	}
	
	/**
	 * Play.
	 *
	 * @param scnr the scnr
	 */
	public void play(Scanner scnr) {
		String keepPlaying = "Yes";
		String playerAnswer = "";
		String format = "\t\t\t%s";
		
		while (keepPlaying.charAt(0) == 'Y') {
			System.out.printf(format, "Possible points: ");
			System.out.print(gameQuestions.get(currQuestionIndex).getValue());
			System.out.println();
			System.out.printf(format, gameQuestions.get(currQuestionIndex).getQuestion());
			System.out.println();
			System.out.printf(format, "Enter your response: ");
			playerAnswer = scnr.nextLine();
			System.out.println();
			
			if (compareAnswer(gameQuestions.get(currQuestionIndex), playerAnswer)) {
				System.out.printf(format, "CORRECT!");
				System.out.println();
				currGameScore += gameQuestions.get(currQuestionIndex).getValue();
				System.out.printf(format, "Your current game score is: ");
				System.out.print(currGameScore);
				System.out.println();
			}
			else {
				System.out.printf(format, "That is an incorrect answer.");
				System.out.println();
				System.out.printf(format, "Your game score stayed at: ");
				System.out.print(currGameScore);
				System.out.println();
			}
			
			System.out.printf(format, "Would you like another question (y/n)? ");
			keepPlaying = scnr.nextLine();
			keepPlaying = keepPlaying.toUpperCase();
			System.out.println();
			currQuestionIndex = getNextIndex();
		}
		currPlayer.addScore(currGameScore);
		System.out.println();
		System.out.printf(format + "\t\t%s \t\t%s \t\t%s", "NAME: " + currPlayer.getName(), "GAMERTAG: " + currPlayer.getGamertag(), "POINTS EARNED: " + getCurrGameScore(), "TOTAL POINTS: " + currPlayer.getScore());
		System.out.println();
		currPlayer.savePlayerFile();
		currPlayer.closeFile();
	}
	
	/**
	 * Compare answer.
	 *
	 * @param question the question
	 * @param userAnswer the user answer
	 * @return true, if successful
	 */
	public boolean compareAnswer(Question question, String userAnswer) {
		return userAnswer.equalsIgnoreCase(question.getAnswer());
	}
}
