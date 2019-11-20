/**
 * This class contains the instance variables and methods for holding a question
 * in a trivia game.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 4
 * file name	Question.java
 */

public class Question {
	
	/** The activated. */
	private boolean activated;
	
	/** The question. */
	private String question;
	
	/** The answer. */
	private String answer;
	
	/** The value. */
	private int value;
	
	/** The question ID. */
	private String questionID;
	
	/**
	 * Instantiates a new question.
	 */
	public Question() {
		setActivated("D");
		setQuestion(null);
		setAnswer(null);
		setValue(0);
		setQuestionID("000");
	}
	
	/**
	 * Instantiates a new question.
	 *
	 * @param activated the activated
	 * @param questionID the question ID
	 * @param question the question
	 * @param answer the answer
	 * @param value the value
	 */
	public Question(String activated, String questionID, String question, String answer, int value) {
		setActivated(activated);
		setQuestion(question);
		setAnswer(answer);
		setValue(value);
		setQuestionID(questionID);
	}

	/**
	 * Gets the activated.
	 *
	 * @return the activated
	 */
	public boolean getActivated() {
		return activated;
	}
	
	/**
	 * Sets the activated.
	 *
	 * @param activated the new activated
	 */
	public void setActivated(String activated) {
		activated = activated.toUpperCase();
		if (activated.charAt(0) == 'A')
			this.activated = true;
		else
			this.activated = false;
	}
	
	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Gets the answer.
	 *
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Sets the answer.
	 *
	 * @param answer the new answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the question ID.
	 *
	 * @return the question ID
	 */
	public String getQuestionID() {
		return questionID;
	}

	/**
	 * Sets the question ID.
	 *
	 * @param questionID the new question ID
	 */
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

}
