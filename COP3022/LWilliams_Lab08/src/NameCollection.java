// TODO: Auto-generated Javadoc
/**
 * This class overrides the EnumInterface methods.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Lab 08
 * file name	NameCollection.java
 */

public class NameCollection implements EnumInterface{
	
	/** The objects. */
	private Object[] objects;
	
	/** The index. */
	private int index;
	
	/**
	 * Instantiates a new name collection.
	 *
	 * @param objects the objects
	 */
	public NameCollection(Object[] objects) {
		setObjects(objects);
		setIndex(0);
	}
	
	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean hasNext() {
		int size = objects.length - 1;
		return index <= size;
	}
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	@Override
	public Object getNext() {
		if (hasNext()) {
			index++;
			return objects[index];
		}
		else
			return null;
	}
	
	/**
	 * Sets the objects.
	 *
	 * @param objects the new objects
	 */
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	
	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Gets the objects.
	 *
	 * @return the objects
	 */
	public Object[] getObjects() {
		return objects;
	}
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String text = "";
		while (hasNext()) {
			text += getObjects()[getIndex()];
			text += " ";
			index++;
		}
		return text;
	}
}
