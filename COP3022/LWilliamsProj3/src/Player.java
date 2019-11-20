// TODO: Auto-generated Javadoc
/**
 * This class is an abstract class that controls the Golfer and Bowler classes.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Project 3
 * file name	Player.java
 */

public abstract class Player {
	
	/** The name. */
	private String name;
	
	/** The ID num. */
	private int IDNum;
	
	/** The next ID num. */
	static int nextIDNum = 1000;
	
	/**
	 * Calculate handicap.
	 *
	 * @return the double
	 */
	abstract double calculateHandicap();
	
	/**
	 * Instantiates a new player.
	 */
	public Player() {
		setName("John Doe");
		setIDNum(0);
	}
	
	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 */
	public Player(String name) {
		setName(name);
		setIDNum(nextIDNum);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the ID num.
	 *
	 * @return the ID num
	 */
	public int getIDNum() {
		return IDNum;
	}

	/**
	 * Sets the ID num.
	 *
	 * @param IDNum the new ID num
	 */
	public void setIDNum(int IDNum) {
		this.IDNum = IDNum;
		nextIDNum++;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Player Name: " + getName() + "\tID: " + getIDNum();
	}
		
}
