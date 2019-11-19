/**
 * This class handles creating and drawing a Car object.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 5
 * file name	Car.java
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * The Class Car.
 */
public class Car {
	
	/** The x left. */
	private int xLeft;
	
	/** The y top. */
	private int yTop;
	
	/** The forward. */
	private boolean forward;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param x position
	 * @param y position
	 */
	public Car(int x, int y) {
		setxLeft(x);
		setyTop(y);
		setForward(true);
	}

	/**
	 * Gets the x left position.
	 *
	 * @return the x left
	 */
	public int getxLeft() {
		return xLeft;
	}

	/**
	 * Sets the x left postion.
	 *
	 * @param x the new x left
	 */
	public void setxLeft(int x) {
		this.xLeft = x;
	}

	/**
	 * Gets the y top position.
	 *
	 * @return the y top
	 */
	public int getyTop() {
		return yTop;
	}

	/**
	 * Sets the y top position.
	 *
	 * @param y the new y top
	 */
	public void setyTop(int y) {
		this.yTop = y;
	}

	/**
	 * Checks if movement is forward.
	 *
	 * @return true, if is forward
	 */
	public boolean isForward() {
		return forward;
	}

	/**
	 * Sets the forward movement boolean.
	 *
	 * @param forward the new forward
	 */
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	
	/**
	 * Translate the movement of cars.
	 *
	 * @param xMove the x move
	 * @param yMove the y move
	 */
	public void translate(int xMove, int yMove) {
		if (!isForward())
			this.xLeft -= xMove;
		else
			this.xLeft += xMove;
		this.yTop += yMove;
	}
	
	/**
	 * Draw the cars.
	 *
	 * @param graphic2D the graphic 2 D
	 */
	public void draw(Graphics2D graphic2D) {
		Rectangle carBody = new Rectangle(xLeft, yTop + 10, 60, 10);      
        Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
        Ellipse2D.Double rearTire  = new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);
     
        Point2D.Double bottomOfWindshield = new Point2D.Double(xLeft + 10, yTop + 10);
        Point2D.Double frontOfRoof = new Point2D.Double(xLeft + 20, yTop);
        Point2D.Double rearOfRoof = new Point2D.Double(xLeft + 40, yTop);
        Point2D.Double bottomRearWindshield = new Point2D.Double(xLeft + 50, yTop + 10);
     
        Line2D.Double frontWindshield = new Line2D.Double(bottomOfWindshield, frontOfRoof);
        Line2D.Double roofTop = new Line2D.Double(frontOfRoof, rearOfRoof);
        Line2D.Double rearWindshield = new Line2D.Double(rearOfRoof, bottomRearWindshield);
     
        graphic2D.draw(carBody);
        graphic2D.draw(frontTire);
        graphic2D.draw(rearTire);
        graphic2D.draw(frontWindshield);      
        graphic2D.draw(roofTop);      
        graphic2D.draw(rearWindshield);
	}
}
