/**
 * This class tests the methods of the ContactList class.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab 03
 * file name	ContactListTester.java
 */

public class ContactListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContactList contacts = new ContactList();
		ContactListEntry contact1 = new ContactListEntry("Luke A. Williams", 4257751, "law67@students.uwf.edu");
		contacts.addContact(contact1);
		
		ContactListEntry contact2 = new ContactListEntry();
		contact2.setName("James Booker");
		contact2.setEmail("jbooker@website.com");
		contact2.setPhoneNumber(5551111);
		contacts.addContact(contact2);
		
		ContactListEntry contact3 = new ContactListEntry();
		contact3.setName("Edward Sheeran");
		contact3.setEmail("sheeranmusic@website.com");
		contact3.setPhoneNumber(5551254);
		contacts.addContact(contact3);
		
		System.out.println(contacts.toString());
		
		contacts.addContact(new ContactListEntry("Amanda Williams", 5551234, "email@website.org"));
		System.out.println(contacts.toString());
		

	}

}
