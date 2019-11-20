/**
 * This class defines the toppings panel for choosing the type of toppings in a Deli GUI
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	ToppingsPanel.java
 */
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * The Class ToppingsPanel.
 */
public class ToppingsPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The toppings. */
	private ArrayList<String> toppings;
	
	/** The cost. */
	private double cost;
	
	/**
	 * Instantiates a new toppings panel.
	 */
	public ToppingsPanel() {
		super();
		setCost(0.0);
		
		toppings = new ArrayList<String>();
		toppings.add("Turkey");
		toppings.add("Chicken");
		toppings.add("Ham");
		toppings.add("Roast Beef");
//		toppings.add("Swiss");
//		toppings.add("Cheddar");
//		toppings.add("Provolone");
//		toppings.add("American");
//		toppings.add("Lettuce");
//		toppings.add("Tomato");
//		toppings.add("Banana Pepper");
//		toppings.add("Oil & Vinegar");
//		toppings.add("Salt & Pepper");
//		toppings.add("Sauce");
		
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Toppings"));
		setLayout(new GridLayout(7, 2));
		
		JCheckBox checkBox;
		checkBox = new JCheckBox(toppings.get(0), false);
		checkBox.addItemListener(turkey -> {
			if (turkey.getStateChange() == 1)
				cost += 1.50;
			else
				cost -= 1.50;
		});
		add(checkBox);
		checkBox = new JCheckBox(toppings.get(1), false);
		checkBox.addItemListener(chicken -> {
			if (chicken.getStateChange() == 1)
				cost += 1.75;
			else
				cost -= 1.75;
		});
		add(checkBox);
		checkBox = new JCheckBox(toppings.get(2), false);
		checkBox.addItemListener(ham -> {
			if (ham.getStateChange() == 1)
				cost += 2.00;
			else
				cost -= 2.00;
		});
		add(checkBox);
		checkBox = new JCheckBox(toppings.get(3), false);
		checkBox.addItemListener(beef -> {
			if (beef.getStateChange() == 1)
				cost += 1.00;
			else
				cost -= 1.00;
		});
		add(checkBox);

	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return this.cost;
	}
}
