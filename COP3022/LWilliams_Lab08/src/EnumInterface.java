// TODO: Auto-generated Javadoc
/**
 * This interface requires implementing classes to include a hasNext()
 * and getNext() method.
 * 
 * @author spooky
 * @version 1.0
 *
 * COP3320	Lab 08
 * file name	EnumInterface.java
 */

public interface EnumInterface {
	
	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	public boolean hasNext();
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Object getNext();
}
