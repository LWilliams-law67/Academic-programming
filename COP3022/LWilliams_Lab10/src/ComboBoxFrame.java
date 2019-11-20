/**
 * This class builds a GUI using a JComboBox and images.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Lab 10
 * file name	ComboBoxFrame.java
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Class ComboBoxFrame.
 */
public class ComboBoxFrame extends JFrame implements ActionListener {
   
   /** The Constant serialVersionUID. */
   private static final long serialVersionUID = 1L;
   
   /** The images J combo box. */
   private JComboBox<String> imagesJComboBox;
   
   /** The image. */
   private JLabel image;
   
   /** The panel. */
   private JPanel panel;
   
   /** The Constant names. */
   private static final String[] names = { "747.jpg", "707.jpg",  "Concorde.jpg" };
   
   /** The image name. */
   private String imageName;
   
   /** The icon. */
   private ImageIcon icon;
  
   /**
    * Instantiates a new combo box frame.
    */
   public ComboBoxFrame() {
	   super("LWilliams_Lab10");
	   imagesJComboBox = new JComboBox<String>(names);
	   setLayout(new FlowLayout());
	   imagesJComboBox.addActionListener(this);
	   imageName = (String)imagesJComboBox.getSelectedItem();
	   
	   icon = new ImageIcon(imageName);
	   
	   image = new JLabel();
	   image.setHorizontalAlignment(JLabel.CENTER);
	   image.setIcon(icon);
	   
	   
	   panel = new JPanel();
	   panel.setLayout(new GridLayout(2,1));
	   panel.add(imagesJComboBox);
	   panel.add(image);

	   add(panel, BorderLayout.CENTER);
	   add(imagesJComboBox);
	   add(image);
	   super.pack();
   }
   
   /**
    * Action performed.
    *
    * @param event the event
    */
   @Override
   public void actionPerformed(ActionEvent event) {
       imageName = (String)imagesJComboBox.getSelectedItem();
       icon = new ImageIcon(imageName);
       image.setIcon(icon);
       super.pack();
   }
}