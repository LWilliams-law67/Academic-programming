/**
 * This class creates and tests the ComboBoxFrame class.
 * 
 * @author Luke Williams
 * @version 1.0
 * 
 * COP3320	Lab 10
 * file name	ComboBoxTest.java
 */
import javax.swing.JFrame;

/**
 * The Class ComboBoxTest.
 */
public class ComboBoxTest
{
   
   /**
    * The main method.
    *
    * @param args the arguments
    */
   public static void main( String[] args )
   { 
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); 
      comboBoxFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      comboBoxFrame.setSize( 500, 400 ); // set frame size
      comboBoxFrame.setVisible( true ); // display frame
   } // end main
} // end class ComboBoxTest
