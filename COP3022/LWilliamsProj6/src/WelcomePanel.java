/**
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Project 6
 * file name	WelcomePanel.java
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Font;



// TODO: Auto-generated Javadoc
/**
 * The Class WelcomePanel.
 */
public class WelcomePanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The shop name. */
	private final String shopName = "Order Selection";
	
	/** The welcome label. */
	private JLabel welcomeLabel;
	
	/**
	 * Instantiates a new welcome panel.
	 */
	public WelcomePanel() {
		super();
		welcomeLabel = new JLabel(shopName);
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
		add(welcomeLabel, BorderLayout.CENTER);
		setBorder(BorderFactory.createBevelBorder(5));
	}
}
