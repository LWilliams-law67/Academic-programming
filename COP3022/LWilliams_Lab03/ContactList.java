/**
 * This class uses an array of ContactListEntry objects to implement a users contact list.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab 03
 * file name	ContactList.java
 */
public class ContactList {
	private int numOfEntries;
	private ContactListEntry[] contacts;
	
	/**
	 * Default constructor.
	 */
	public ContactList() {
		this.numOfEntries = 0;
		this.contacts = new ContactListEntry[10];
	}

	/**
	 * @param newContact
	 */
	public void addContact(ContactListEntry contact) {
		this.contacts[numOfEntries] = contact;
		this.numOfEntries++;
		
	}

	@Override
	public String toString() {
		StringBuilder contactListString = new StringBuilder("Contacts: " + this.numOfEntries + "\n");
		
		for (int i = 0; i < this.numOfEntries; i++) {
			contactListString.append(contacts[i].getName());
			contactListString.append("\n");
			contactListString.append(contacts[i].getPhoneNumber());
			contactListString.append("\n");
			contactListString.append(contacts[i].getEmail());
			contactListString.append("\n\n");
			
		}
		return contactListString.toString();
	}
	
}
