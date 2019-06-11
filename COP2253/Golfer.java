/**
   COP2253 Java programming
   This is a class designed to represent a golfer including his name, home course, id number
   and an Array of Score Objects. The golfers scores consist of several pieces of information
   including the course, the par score for the course, the courses rating and course slope,
   the date  the score was shot and the score itself.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 6
   filename: Golfer.java
*/

import java.util.Scanner;

public class Golfer
{
   private String name;
   private String homeCourse;
   private int idNum;
   private Score[] scores;
   private int numOfScores;
   static int nextIDNum = 1000;

   public Golfer()
   {
      setName("John Doe");
      setHomeCourse("Nomad");
      setIDNum(nextIDNum);
      scores = new Score[10];
      numOfScores = 0;
   }

   public Golfer(String name, String homeCourse)
   {
      setName(name);
      setHomeCourse(homeCourse);
      setIDNum(nextIDNum);
      scores = new Score[10];
      numOfScores = 0;
   }

   //Simple getter functions to return the private members
   public String getName()
   {
      return name;
   }

   public String getHomeCourse()
   {
      return homeCourse;
   }

   public int getIDNum()
   {
      return idNum;
   }

   //Simple setter functions to set the private members
   public void setName(String setName)
   {
      name = setName;
   }

   public void setHomeCourse(String setHomeCourse)
   {
      homeCourse = setHomeCourse;
   }

   public void setIDNum(int setIDNum)
   {
      idNum = setIDNum;
      nextIDNum++;
   }

   //creates and adds a new Score object for the golfer and puts the object into the Golfer's array of scores.
   public void addScores(String course, int score, double rating, int slope, String date)
   {
      scores[numOfScores] = new Score(course, score, date, rating, slope);
      numOfScores++;
      if (numOfScores >= 9)
         numOfScores = 0;
   }

/*
   public boolean deleteScore(String date)
   {
      Not logical to 'delete' an element from an array.
   }
*/

   public Score getScore(String date)
   {
      for(int i = 0; i < numOfScores; i++)
      {
         if (date == scores[i].getDate())
            return scores[i];
      }
      return null;
   }
    
}
