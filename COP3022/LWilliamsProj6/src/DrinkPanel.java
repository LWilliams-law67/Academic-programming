/**
 * This class defines the drink panel for choosing the type of drink in a Deli GUI
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	ToppingsPanel.java
 */
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * The Class DrinkPanel.
 */
public class DrinkPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The button group. */
	private ButtonGroup buttonGroup;
	
	/** The drinks. */
	private ArrayList<String> drinks;
	
	/** The cost. */
	private double cost;
	
	/**
	 * Instantiates a new drink panel.
	 */
	public DrinkPanel() {
		super();
		setCost(0.0);

		drinks = new ArrayList<String>();
		drinks.add("Coke");
		drinks.add("Water");
		drinks.add("Sprite");
//		drinks.add("Hawaiian Punch");
//		drinks.add("Diet Coke");
		
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Drink"));
		setLayout(new GridLayout(5,1));
		
		JRadioButton radioButton;
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton = new JRadioButton(drinks.get(0), false));
		radioButton.addItemListener(coke -> {
			if (coke.getStateChange() == 1)
				cost += 1.75;
			else
				cost -= 1.75;
		});
		add(radioButton);
		
		buttonGroup.add(radioButton = new JRadioButton(drinks.get(1), false));
		radioButton.addItemListener(water -> {
			if (water.getStateChange() == 1)
				cost += 0.20;
			else
				cost -= 0.20;
		});
		add(radioButton);
		
		buttonGroup.add(radioButton = new JRadioButton(drinks.get(2), false));
		radioButton.addItemListener(sprite-> {
			if (sprite.getStateChange() == 1)
				cost += 1.50;
			else
				cost -= 1.50;
		});
		add(radioButton);
		
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
