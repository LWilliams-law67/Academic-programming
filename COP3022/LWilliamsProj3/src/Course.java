// TODO: Auto-generated Javadoc
/**
 * This class contains golf course information.
 * 
 * @author spooky
 * @version 1.0
 * 
 *COP3320	Project 3
 *file name	Course.java
 */

public class Course {
	
	/** The name. */
	private String name;
	
	/** The rating. */
	private double rating;
	
	/** The slope. */
	private int slope;
	
	/**
	 * Instantiates a new course.
	 */
	public Course() {
		setName("nowhere");
		setRating(60.0);
		setSlope(55);
	}
	
	/**
	 * Instantiates a new course.
	 *
	 * @param name the name
	 * @param rating the rating
	 * @param slope the slope
	 */
	public Course(String name, double rating, int slope) {
		setName(name);
		setRating(rating);
		setSlope(slope);
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
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(double rating) {
		if (rating >= 60 && rating <= 80)
	         this.rating = rating;
	      else
	      {
	         System.out.println("Error: the intended rating is out of bounds. Rating defaulted to 9999.");
	         this.rating = 9999;
	      }
	}

	/**
	 * Gets the slope.
	 *
	 * @return the slope
	 */
	public int getSlope() {
		return slope;
	}

	/**
	 * Sets the slope.
	 *
	 * @param slope the new slope
	 */
	public void setSlope(int slope) {
		if (slope >= 55 && slope <= 155)
	         this.slope = slope;
	      else {
	         System.out.println("Error: the intended slope is out of bounds. Slope defaulted to 9999.");
	         this.slope = 9999;
	      }
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("Course: %s, \tRating: %.2f \tSlope: %d", getName(), getRating(), getSlope());
	}
		
}
