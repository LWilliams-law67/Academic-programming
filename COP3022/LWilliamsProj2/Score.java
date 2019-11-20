/**
 * This contains the methods to store and alter a Golfer's score
 * 
 * @author spooky
 * @version 2.0
 * 
 * COP3022	Project 2
 * file name	Score.java
 */

public class Score
{
   
   /**
   * course
   * score
   * courseRating
   * courseSlope
   * date
   */
   private String courseName;
   private int score;
   private double courseRating;
   private int courseSlope;
   private String date;

   /**
   * Default Constructor
   */
   public Score()
   {
      courseName = "Nowhere";
      score = 0;
      courseRating = 0.0;
      courseSlope = 0;
      date = "00/00/00";
   }

   /**
   * @param courseName
   * @param score
   * @param date
   * @param courseRating
   * @param courseSlope
   */
   public Score(String courseName, int score, String date, double courseRating, int courseSlope)
   {
      setCourseName(courseName);
      setDate(date);
      setScore(score);
      setCourseRating(courseRating);
      setSlope(courseSlope);
   }

   /**
   * @return course
   */
   public String getCourseName()
   {
      return courseName;
   }

   /**
 * @return score
 */
public int getScore()
   {
      return score;
   }

   /**
 * @return courseRating
 */
public double getCourseRating()
   {
      return courseRating;
   }

   /**
 * @return courseSlope
 */
public int getSlope()
   {
      return courseSlope;
   }

   /**
 * @return date
 */
public String getDate()
   {
      return date;
   }

   /**
 * @param courseName
 */
public void setCourseName(String courseName)
   {
      this.courseName = courseName;
   }

   /**
 * @param score
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
 * @param courseRating
 */
public void setCourseRating(double courseRating)
   {
      if (courseRating >= 60 && courseRating <= 80)
         this.courseRating = courseRating;
      else
      {
         System.out.println("Error: the intended rating is out of bounds. Rating defaulted to 9999.");
         this.courseRating = 9999;
      }
   }

   /**
 * @param slope
 */
public void setSlope(int slope)
   {
      if (slope >= 55 && slope <= 155)
         this.courseSlope = slope;
      else
      {
         System.out.println("Error: the intended slope is out of bounds. Slope defaulted to 9999.");
         this.courseSlope = 9999;
      }
   }

   /**
 * @param date
 */
public void setDate(String date)
   {
      this.date = date;
   }

   /**
 * generates a formatted with instance variables
 */
public String toString()
   {
      return String.format("\n\t\t%-35s %-5d %-5.1f %-5d %-15s", courseName, score, courseRating, courseSlope, date);
   }
}
