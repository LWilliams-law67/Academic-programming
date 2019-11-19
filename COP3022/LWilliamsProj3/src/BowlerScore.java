// TODO: Auto-generated Javadoc
/**
 * This class holds the information for a bowling score.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 3
 * file name	BowlerScore.java
 */

public class BowlerScore {
	
	/** The lane name. */
	private String laneName;
	
	/** The score. */
	private int score;
	
	/** The date. */
	private String date;
	
	/**
	 * Instantiates a new bowler score.
	 */
	public BowlerScore() {
		setLaneName("no lanes");
		setScore(0);
		setDate("00/00/00");
	}
	
	/**
	 * Instantiates a new bowler score.
	 *
	 * @param laneName the lane name
	 * @param score the score
	 * @param date the date
	 */
	public BowlerScore(String laneName, int score, String date) {
		setLaneName(laneName);
		setScore(score);
		setDate(date);
	}

	/**
	 * Gets the lane name.
	 *
	 * @return the lane name
	 */
	public String getLaneName() {
		return laneName;
	}

	/**
	 * Sets the lane name.
	 *
	 * @param laneName the new lane name
	 */
	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("\n\t\t%15d %15s %35s", getScore(), getDate(), getLaneName());
	}
	
}
