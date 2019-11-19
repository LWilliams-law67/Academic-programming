/**
 * This class defines a Deli GUI for ordering food
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	OrderCalc.java
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class OrderCalc.
 */
public class OrderCalc extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -928402904357145158L;
	
	/** The welcome. */
	private WelcomePanel welcome;
	
	/** The bread. */
	private BreadPanel bread;
	
	/** The toppings. */
	private ToppingsPanel toppings;
	
	/** The drink. */
	private DrinkPanel drink;
	
	/** The calculate. */
	private JButton calculate;
	
	/** The exit. */
	private JButton exit;
	
	/** The button panel. */
	private JPanel buttonPanel;
	
	/** The order amount. */
	private double orderAmount;
	
	/** The tax amount. */
	private double taxAmount;
	
	/**
	 * The listener interface for receiving calculate events.
	 * The class that is interested in processing a calculate
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addCalculateListener<code> method. When
	 * the calculate event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see CalculateEvent
	 */
	private class CalculateListener implements ActionListener {
		
		/**
		 * Action performed.
		 *
		 * @param event the event
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			double orderSubTotal = bread.getCost() + toppings.getCost() + drink.getCost();
			setOrderAmount(orderSubTotal);
			setTaxAmount(calculateTaxAmount());
			// creates a JFrame for the checkout
			JFrame checkoutWindow = new JFrame("Checkout");
			checkoutWindow.setPreferredSize(new Dimension(200,100));
			checkoutWindow.setVisible(true);
			checkoutWindow.setLayout(new GridLayout(3,2));
			checkoutWindow.setAlwaysOnTop(true);
			checkoutWindow.setResizable(false);
			// creates labels for the subtotal and it's value
			JLabel subTotalLabel = new JLabel("Subtotal: ");
			String subtotal = String.format("%.2f", getOrderAmount());
			JLabel subTotalAmountLabel = new JLabel(subtotal);
			// creates labels for tax and it's value
			JLabel taxLabel = new JLabel("Tax: ");
			String tax = String.format("%.2f", getTaxAmount());
			JLabel taxAmountLabel = new JLabel(tax);
			// creates labels for total cost and it's value
			JLabel totalLabel = new JLabel("Total: ");
			String totalAmount = String.format("%.2f", (getOrderAmount() + getTaxAmount()));
			JLabel orderAmountLabel = new JLabel(totalAmount);
			// adds all labels to the checkout frame
			checkoutWindow.add(subTotalLabel);
			checkoutWindow.add(subTotalAmountLabel);
			checkoutWindow.add(taxLabel);
			checkoutWindow.add(taxAmountLabel);
			checkoutWindow.add(totalLabel);
			checkoutWindow.add(orderAmountLabel);
			
			checkoutWindow.pack();
		}
	}
	
	/**
	 * The listener interface for receiving exit events.
	 * The class that is interested in processing a exit
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addExitListener<code> method. When
	 * the exit event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see ExitEvent
	 */
	private class ExitListener implements ActionListener {
		
		/**
		 * Action performed.
		 *
		 * @param event the event
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	/**
	 * Instantiates a new order calc.
	 */
	public OrderCalc() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// initializes objects for all panels
		welcome = new WelcomePanel();
		bread = new BreadPanel();
		toppings = new ToppingsPanel();
		drink = new DrinkPanel();
		buttonPanel = new JPanel();
		// initializes buttons and adds them to appropriate panel
		calculate = new JButton("Calculate");
		exit = new JButton("EXIT");
		buttonPanel.add(calculate, BorderLayout.LINE_START);
		buttonPanel.add(exit, BorderLayout.LINE_END);
		// creates and adds listeners to buttons
		calculate.addActionListener(new CalculateListener());
		exit.addActionListener(new ExitListener());
		// adds instance variables to the GUI
		add(welcome, BorderLayout.PAGE_START);
		add(bread, BorderLayout.LINE_START);
		add(toppings, BorderLayout.CENTER);
		add(drink, BorderLayout.LINE_END);
		add(buttonPanel, BorderLayout.PAGE_END);
		super.pack();
		
		orderAmount = 0.0;
		taxAmount = 0.0;
	}
	
	/**
	 * Sets the order amount.
	 *
	 * @param orderAmount the new order amount
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * Gets the order amount.
	 *
	 * @return the order amount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	
	/**
	 * Sets the tax amount.
	 *
	 * @param taxAmount the new tax amount
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * Gets the tax amount.
	 *
	 * @return the tax amount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}
	
	/**
	 * Calculate tax amount.
	 *
	 * @return the double
	 */
	public double calculateTaxAmount() {
		return orderAmount * 0.06;
	}
	
}
