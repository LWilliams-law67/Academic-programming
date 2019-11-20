// TODO: Auto-generated Javadoc
/**
 * This class extends the Player class and contains data for a Bowler.
 *
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 3
 * file name	Bowler.java
 */

public class Bowler extends Player {
	
	/** The team name. */
	private String teamName;
	
	/** The scores. */
	private BowlerScore[] scores;
	
	/** The num scores. */
	private int numScores;
	
	/**
	 * Instantiates a new bowler.
	 */
	public Bowler() {
		super.setName("John Doe");
	    super.setIDNum(nextIDNum);
	    setTeamName("newbies");
	    scores = new BowlerScore[10];
	    numScores = 0;
	}
	
	/**
	 * Instantiates a new bowler.
	 *
	 * @param playerName the player name
	 * @param teamName the team name
	 */
	public Bowler(String playerName, String teamName) {
		super.setName(playerName);
	    super.setIDNum(nextIDNum);
	    setTeamName(teamName);
	    scores = new BowlerScore[10];
	    numScores = 0;
	}

	/**
	 * Gets the team name.
	 *
	 * @return the team name
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Sets the team name.
	 *
	 * @param teamName the new team name
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * Adds the scores.
	 *
	 * @param score the score
	 */
	public void addScores(BowlerScore score) {
	      scores[numScores] = score;
	      numScores++;
	      if (numScores >= 9)
	         numScores = 0;
	}
	
	/**
	 * Calculate handicap.
	 *
	 * @return the double
	 */
	public double calculateHandicap() {
		double h = 0;
		if (numScores < 5)
			return 0.0;
		for (int i = numScores; i > (numScores - 5); i--) {
			if (i >= 0)
				h = h + scores[i].getScore();
			else
				break;
		}
		h = h / 5;
		h = 200 - h;
		h = h * .80;
		h = round2DP(h);
		
		return h;
	}
	
	/**
	 * Round 2 DP.
	 *
	 * @param d the d
	 * @return the double
	 */
	private double round2DP(double d) {
		   int temp = (int)(d * 100);
		   return ((double)temp) / 100;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String scoreInfo = "";
		for (int i = 0; i < numScores; i++)
			scoreInfo += scores[i].toString();
		
		return String.format("\n\t\tNAME: %-20s ID: %-10d, HANDICAP: %.2f \n\t\tSCORES:\n\t\t %s", super.getName(), super.getIDNum(), calculateHandicap(), scoreInfo);
	}
}
