/**
 * This class stores a container of car objects.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320 Project 5
 * file name	CarComponent.java
 */
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

/**
 * The Class CarComponent.
 */
public class CarComponent extends JComponent {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cars. */
	private ArrayList<Car> cars;
	
	/**
	 * Instantiates a new car component.
	 */
	public CarComponent() {
		cars = new ArrayList<Car>();
	}
	
	/**
	 * Adds a car to ArrayList cars.
	 *
	 * @param car the car
	 */
	public void add(Car car) {
		cars.add(car);
	}
	
	/**
	 * Move cars.
	 */
	public void moveCars() {
		Random rand = new Random();
		int xMove = 0;

		for (int i = 0; i < cars.size(); i++) {
			// Reverse car movement direction if car position is outside of JFrame window.
			if (cars.get(i).getxLeft() + 60 >= CarMover.FRAME_WIDTH)
				cars.get(i).setForward(false);
			if (cars.get(i).getxLeft() < 0)
				cars.get(i).setForward(true);
			
			xMove = rand.nextInt(20);
			cars.get(i).translate(xMove, 0);
		}
	}
	
	/**
	 * Paint component cars.
	 *
	 * @param graphic the graphic
	 */
	public void paintComponent(Graphics graphic) {
		Graphics2D graphic2D = (Graphics2D) graphic;
		for (Car car : cars)
			car.draw(graphic2D);
	}
}
