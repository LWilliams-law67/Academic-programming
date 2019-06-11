/**
   COP2253 Java programming
   This program draws a Fence. The pound sign (#) is used for the outline of the fence
   and the pipe character (|) is used for the fence bars. A static variable (fenceCount) keeps
   track of the amount of fence objects created in a single run of this program.
   This file provides the Fence methods for the user to define the height and width; as well as,
   provides the method to output (draw) the fence to the console screen for the user to view.

   
   @author lwilliams
   @version 1.0
   
   COP2253 project 5
   filename: Fence.java
*/

import java.util.Scanner;

public class Fence
{
   private int height;
   private int width;
   private static int fenceCount;

   public Fence() {
      height = 0;
      width = 0;
      fenceCount = 0;
   }

   public Fence(int height, int width) {
      this.height = height;
      this.width = width;
      fenceCount = 0;
   }

   public int getHeight() {
      return height;
   }

   public int getWidth() {
      return width;
   }

   public int getFenceCount() {
      return fenceCount;

   }

   public void setHeight(int newHeight) {
      height = newHeight;
   }

   public void setWidth(int newWidth) {
      width = newWidth;
   }

   public void draw() {
      String fenceFrame = "#";
      String fenceBars = "|";

      // Increments the fenceCount to keep track of the total number of fences that are built.
      fenceCount += 1;

      // Outer loop to print fence and control the height.
      for(int h = 0; h < height; h++) {
         System.out.print(fenceFrame);
         // Inner loop to control the width (width-2 leaves room for left and right fence frame).
         for(int w = 0; w < width-2; w++) {
            // If-else statement makes sure fence frame is printed for the first and last line.
            if(h == 0 || h == height-1)
               System.out.print(fenceFrame);
            else
               System.out.print(fenceBars);
         }
         System.out.println(fenceFrame);
      }
   }
}