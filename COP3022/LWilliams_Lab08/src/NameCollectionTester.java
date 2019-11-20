// TODO: Auto-generated Javadoc
/**
 * This class tests the NameCollection class and its methods.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Lab 08
 * file name	NameCollectionTester.java
 */

public class NameCollectionTester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String[] names = new String[] {"John", "Jacob", "Jingle", "Heimer", "Schmidt"};
		System.out.println("John, Jacob, Jingle, Heimer, Schmidt added  to String[] names.");
		
		NameCollection tester = new NameCollection(names);
		System.out.println("NameCollection tester created using String[] names via mutator methods.");
		
		System.out.println("tester toString() method uses getter methods and outputs:");
		System.out.println(tester.toString());

	}

}
