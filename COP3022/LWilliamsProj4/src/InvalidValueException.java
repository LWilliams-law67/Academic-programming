/**
 * This class extends the Exception class and throws an exception
 * if an administrator enters a question value that is not 1-5 inclusive
 * for the trivia game.
 * 
 * @author spooky
 * @version
 * 
 * COP3320	Project 4
 * file name	InvalidValueException.java
 */

public class InvalidValueException extends Exception {
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new invalid value exception.
	 *
	 * @param message the message
	 */
	public InvalidValueException(String message) {
		this.message = message;
	}
	
	/**
	 * Message.
	 *
	 * @return the string
	 */
	public String message() {
		return ("InvalidValueException occurred: " + message);
	}
}
