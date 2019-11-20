/**
 * This class extends the Player class and holds the name, home course, identification number, and up to 10
 * Scores for a Golfer.
 * 
 * @author spooky
 * @version 3.0
 * 
 * COP3022	Project 3
 * file name	Golfer.java
 */
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Golfer.
 */
public class Golfer extends Player {
   
   /** The home course. */
   private String homeCourse;
   
   /** The scores. */
   private Score[] scores;
   
   /** The num scores. */
   private int numScores;
   
   /** The handicap. */
   private double handicap;
   
   /** The Constant NOTFOUND. */
   final static int NOTFOUND = -1;

   /**
    * Find score.
    *
    * @param date the date
    * @return the int
    */
   private int findScore(String date) {
	   for (int i = 0; i < numScores; i++)
	    	  if (scores[i].getDate().equals(date))
	    		  return i;
	    		  
	   return NOTFOUND;   
   }

   /**
    * Instantiates a new golfer.
    */
   public Golfer() {
      super.setName("John Doe");
      super.setIDNum(nextIDNum);
      setHomeCourse("none");
      setHandicap(0);
      scores = new Score[10];
      numScores = 0;
   }

   /**
    * Instantiates a new golfer.
    *
    * @param name the name
    * @param homeCourse the home course
    */
   public Golfer(String name, String homeCourse) {
      super.setName(name);
      super.setIDNum(nextIDNum);
      setHomeCourse(homeCourse);
      setHandicap(0);
      scores = new Score[10];
      numScores = 0;
   }

   /**
    * Calculate handicap.
    *
    * @return the double
    */
   public double calculateHandicap() {
	   ArrayList<Double> differentials = new ArrayList<>();
	   double diff;
	   for(int i = 0; i < numScores; i++) {
		   diff = ((scores[i].getScore() - scores[i].getCourse().getRating()) * (113 / scores[i].getCourse().getSlope()));
		   diff = round2DP(diff);
		   differentials.add(diff);
	   }
	   
	   double max = 0;
	   int index = 0;
	   while (differentials.size() > 5) {
		   for (int i = 0; i < differentials.size(); i++) {
			   if (differentials.get(i) > max) {
				   max = differentials.get(i);
				   index = i;
			   }
		   }
		   differentials.remove(index);
	   }
	   if (differentials.size() > 5)
		   for (int i = differentials.size(); i > 5; i--)
			   differentials.remove(i - 1);
	   
	   int diffSize = differentials.size();
	   double h = 0.0;
	   
	   if (diffSize < 5)
		   for (int i = 0; i < (5 - diffSize); i++)
			   h += differentials.get(i);
	   for (int i = 0; i < diffSize; i++) {
		   h += differentials.get(i);
	   }
	   
	   h = h / 5;
	   h = round2DP(h);
	   
	   h = h * .96;
	   h = round2DP(h);
	   
	   return h;
	   
   }
   
   /**
    * Gets the handicap.
    *
    * @return the handicap
    */
   public double getHandicap() {
	   return handicap;
   }
   
   /**
    * Sets the handicap.
    *
    * @param handicap the new handicap
    */
   public void setHandicap(double handicap) {
	   this.handicap = handicap;
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
    * Gets the home course.
    *
    * @return the home course
    */
   public String getHomeCourse() {
      return homeCourse;
   }

   /**
    * Sets the home course.
    *
    * @param homeCourse the new home course
    */
   public void setHomeCourse(String homeCourse) {
      this.homeCourse = homeCourse;
   }

   /**
    * Adds the scores.
    *
    * @param course the course
    * @param score the score
    * @param date the date
    */
   public void addScores(Course course, int score, String date) {
      scores[numScores] = new Score(course, score, date);
      numScores++;
      if (numScores >= 9)
         numScores = 0;
   }

   /**
    * Delete score.
    *
    * @param date the date
    * @return true, if successful
    */
   public boolean deleteScore(String date) {
      int index = findScore(date);
      
      if (index > -1 && index < numScores) {
	      for (int i = index; i < numScores; i++)
	    	  scores[i] = scores[i + 1];
	      
	      numScores--;
	      return true;
      }
      
      return false;
   }

   /**
    * Gets the score.
    *
    * @param date the date
    * @return the score
    */
   public Score getScore(String date) {
      int index = findScore(date);
      
      if (index > -1 && index < numScores)
    	  return scores[index];
      
      return null;
   }

   /**
    * Lowest score.
    *
    * @return the score
    */
   public Score lowestScore() {
	   int index = 0;
	   int lowestValue = scores[0].getScore();
	   
	   if (numScores == 0)
		   return null;
	   
	   for (int i = 0; i < numScores; i++) {
		   if (scores[i].getScore() < lowestValue) {
			   index = i;
			   lowestValue = scores[i].getScore();
		   }
	   }
	   
	   return scores[index];
   }

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String scoreString = "";
		for (int i = 0; i < numScores; i++)
			scoreString += scores[i].toString();
		return String.format("\n\t\tNAME: %-20s ID: %-10d, HOME COURSE: %s, HANDICAP: %s \n\t\tSCORES:\n %s", super.getName(), super.getIDNum(), getHomeCourse(), handicap, scoreString);
	}
   
}
