/**
 * This class runs the CarComponent and Car classes, and implements the JFrame.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Project 5
 * file name	CarMover.java
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The Class CarMover.
 */
public class CarMover {
	
	/** The Constant FRAME_WIDTH. */
	public static final int FRAME_WIDTH = 300;
	
	/** The Constant FRAME_HEIGHT. */
	public static final int FRAME_HEIGHT = 400;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Create window and set size, title, and close operation.
		JFrame window = new JFrame();
		
		window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		window.setTitle("LWilliams Project 5: Racing Cars");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Gets user value for delay of timer.
		String userDelay = JOptionPane.showInputDialog("Enter 'x' delay: ");
		final int delay = Integer.parseInt(userDelay);
		
		// Creates new component and adds four Car objects to it.
		CarComponent cars = new CarComponent();
		Car one = new Car(0,0);
		Car two = new Car(0, FRAME_HEIGHT / 4);
		Car three = new Car(0, FRAME_HEIGHT / 2);
		Car four = new Car(0, FRAME_HEIGHT - 65);
		
		cars.add(one);
		cars.add(two);
		cars.add(three);
		cars.add(four);
		
		// Makes cars visible in window.
		window.add(cars);
		window.setVisible(true);
		
		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				cars.moveCars();
				cars.repaint();
			}
		}
		// Creates and starts timer for racing cars.
		ActionListener listener = new TimerListener();
		Timer timer = new Timer(delay, listener);
		timer.start();	
	}

}
