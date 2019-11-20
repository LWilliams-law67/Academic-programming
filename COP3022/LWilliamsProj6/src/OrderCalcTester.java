/**
 * This tests the Deli GUI class 'OrderCalc'
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	OrderCalcTester.java
 */
import javax.swing.SwingUtilities;


/**
 * The Class OrderCalcTester.
 */
public class OrderCalcTester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OrderCalc order = new OrderCalc();
				order.setTitle("Aunt Mae's Deli");
				order.setSize(800, 600);
				order.setResizable(false);
				order.setVisible(true);
			}
			
		});
		
		
	}
	
	
}
