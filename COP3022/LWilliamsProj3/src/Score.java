// TODO: Auto-generated Javadoc
/**
 * This contains the methods to store and alter a Golfer's score.
 *
 * @author spooky
 * @version 3.0
 * 
 * COP3022	Project 3
 * file name	Score.java
 */

public class Score {
   
   /** The course. */
   private Course course;
   
   /** The score. */
   private int score;
   
   /** The date. */
   private String date;

   /**
    * Instantiates a new score.
    */
   public Score()
   {
      course = new Course();
      score = 0;
      date = "00/00/00";
   }

   /**
    * Instantiates a new score.
    *
    * @param course the course
    * @param score the score
    * @param date the date
    */
   public Score(Course course, int score, String date)
   {
      setCourse(course);
      setDate(date);
      setScore(score);
   }

   /**
    * Gets the course.
    *
    * @return the course
    */
   public Course getCourse()
   {
      return course;
   }

   /**
    * Gets the score.
    *
    * @return the score
    */
   public int getScore()
   {
      return score;
   }

   /**
    * Gets the date.
    *
    * @return the date
    */
   public String getDate()
   {
      return date;
   }

   /**
    * Sets the course.
    *
    * @param course the new course
    */
   public void setCourse(Course course)
   {
      this.course = course;
   }

   /**
    * Sets the score.
    *
    * @param score the new score
    */
   public void setScore(int score)
   {
      if (score >= 40 && score <= 200)
         this.score = score;
      else
      {
         System.out.println("Error: the intended score is out of bounds. Score defaulted to 9999.");
         this.score = 9999;
      }
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
	  String courseInfo = course.toString();
      return String.format("\n\t\t%s SCORE: %-5d DATE: %-15s", courseInfo, score, date);
   }
}
