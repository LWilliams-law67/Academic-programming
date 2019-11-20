/**
 * This class stores a name, phone number, and email for a specific contact.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab 03
 * file name	ContactListEntry.java
 */

public class ContactListEntry {
	private int phoneNumber;
	private String name;
	private String email;
	
	
	/**
	 * Default constructor.
	 */
	public ContactListEntry() {
		this.phoneNumber = 5550000;
		this.name = "John Doe";
		this.email = "None provided";
	}

	/**
	 * @param name
	 * @param phoneNumber
	 * @param email
	 */
	public ContactListEntry(String name, int phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
}
