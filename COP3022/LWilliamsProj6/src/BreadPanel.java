/**
 * This class defines the bread panel for choosing the type of bread in a Deli GUI
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	BreadPanel.java
 */
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * The Class BreadPanel.
 */
public class BreadPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The bread types. */
	private ArrayList<String> breadTypes;
	
	/** The button group. */
	private ButtonGroup buttonGroup;
	
	/** The cost. */
	private double cost;
	
	/**
	 * Instantiates a new bread panel.
	 */
	public BreadPanel() {
		super();
		this.setCost(3.00);

		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Bread"));
		setLayout(new GridLayout(4,1));
		
		breadTypes = new ArrayList<String>();
		breadTypes.add("White");
		breadTypes.add("Wheat");
		breadTypes.add("Italian");
		
		JRadioButton radioButton;
		buttonGroup = new ButtonGroup();
		for (int i = 0; i < breadTypes.size(); i++) {
			buttonGroup.add(radioButton = new JRadioButton(breadTypes.get(i), true));
			add(radioButton);
		}
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
