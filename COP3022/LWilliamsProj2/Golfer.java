/**
 * This class holds the name, home course, identification number, and up to 10
 * Scores for a Golfer.
 * 
 * @author spooky
 * @version 2.0
 * 
 * COP3022	Project 2
 * file name	Golfer.java
 */

public class Golfer
{
   /**
   * name of Golfer
   * homeCourse of Golfer
   * idNum of Golfer
   * scores[] of Golfer, no more than 10
   * numScores of Golfer
   * NOTFOUND constant integer set to -1 for searching through scores by date
   */
   private String name;
   private String homeCourse;
   private int idNum;
   private Score[] scores;
   private int numScores;
   static int nextIDNum = 1000;
   final static int NOTFOUND = -1;
   
   /**
   * @param date
   * @return index of Score if found
   */
   private int findScore(String date) {
	   for (int i = 0; i < numScores; i++)
	    	  if (scores[i].getDate().equals(date))
	    		  return i;
	    		  
	   return NOTFOUND;   
   }

   /**
   * Default Constructor
   */
   public Golfer() {
      setName("John Doe");
      setHomeCourse("Nomad");
      setIDNum(nextIDNum);
      scores = new Score[10];
      numScores = 0;
   }

   
   /**
   * @param name
   * @param homeCourse
   */
   public Golfer(String name, String homeCourse) {
      setName(name);
      setHomeCourse(homeCourse);
      setIDNum(nextIDNum);
      scores = new Score[10];
      numScores = 0;
   }

   
   /**
   * @return name
   */
   public String getName() {
      return name;
   }

   /**
   * @return homeCourse
   */
   public String getHomeCourse() {
      return homeCourse;
   }

   /**
   * @return idNum
   */
   public int getIDNum() {
      return idNum;
   }

   /**
   * @param setName
   */
   public void setName(String name) {
      this.name = name;
   }

   /**
   * @param setHomeCourse
   */
   public void setHomeCourse(String homeCourse) {
      this.homeCourse = homeCourse;
   }

   /**
   * @param setIDNum
   */
   public void setIDNum(int idNum) {
      this.idNum = idNum;
      nextIDNum++;
   }

   /**
   * @param course
   * @param score
   * @param rating
   * @param slope
   * @param date
   */
   public void addScores(String course, int score, double rating, int slope, String date) {
      scores[numScores] = new Score(course, score, date, rating, slope);
      numScores++;
      if (numScores >= 9)
         numScores = 0;
   }

   /**
   * @param date
   * @return true is score found and removed, else false
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
   * @param date
   * @return Score at index if index is valid
   */
   public Score getScore(String date) {
      int index = findScore(date);
      
      if (index > -1 && index < numScores)
    	  return scores[index];
      
      return null;
   }
   
   /**
    * @return Score object with lowest score value
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

	@Override
	public String toString() {
		String scoreString = "";
		for (int i = 0; i < numScores; i++)
			scoreString += scores[i].toString();
		return String.format("\n\t\tNAME: %s, HOME COURSE: %s, ID: %s \n\t\t%s", name, homeCourse, idNum, scoreString);
	}


   
}
