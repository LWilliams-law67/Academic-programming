/**
   COP2253 Java programming
   This is a class designed to represent a golfer's score the course name, course rating,
   course slope, the date and the score itself. This class is implemented with the Golfer class
   and each score object is stored in an array for the Golfer class.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 6
   filename: Score.java
*/

import java.util.Scanner;

public class Score
{
   //Private members that identify and store data for each Score
   private String course;
   private int score;
   private double courseRating;
   private int courseSlope;
   private String date;

   //General consructor produces generic intializations of private members
   public Score()
   {
      course = "Nowhere";
      score = 0;
      courseRating = 0.0;
      courseSlope = 0;
      date = "0/0/00";
   }

   //parameterized constructor sets the values of the private members if the parameters meet the specified criteria
   public Score(String course, int score, String date, double courseRating, int courseSlope)
   {
      setCourse(course);
      setDate(date);
      setScore(score);
      setCourseRating(courseRating);
      setSlope(courseSlope);
   }

   //Simple getter functions to return the private members
   public String getCourse()
   {
      return course;
   }

   public int getScore()
   {
      return score;
   }

   public double getCourseRating()
   {
      return courseRating;
   }

   public int getSlope()
   {
      return courseSlope;
   }

   public String getDate()
   {
      return date;
   }

   //Simple setter functions to set the private members and ensure the member parameters
   public void setCourse(String courseName)
   {
      this.course = courseName;
   }

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

   public void setDate(String date)
   {
      this.date = date;
   }

   //Converts and merges the private members into a string, and formats the string for output
   public String toString()
   {
      return course + "\t" + score + "\t" + courseRating + "\t" + courseSlope + "\t" + date;
   }
}
