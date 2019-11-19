/**
 * This class uses the private members to store an encrypted password and the key for encryption.
 * The methods of this class are used to encrypt and store the user's input.
 * 
 * @author spooky
 * @version 1.0
 * 
 *COP3022    Project #: 1
 *File Name: Encryption.java
 */

public class Encryption {
	private int key;
	private String encryptedPassword;
	
	public Encryption() {
		this.key = 0;
		this.encryptedPassword = "";
	}
	
	/**
	 * @param key to be used to encrypt password.
	 * @param password that needs to be encrypted.
	 */
	public Encryption(int key, String password) {
		setPassword(key, password);
	}

	/**
	 * @param password is String to be encrypted.
	 */
	public String encrypt(String password) {
		// exits this function if an encryption key has not been set.
		if (this.key == 0) {
			System.out.println("A key has not been set. Encryption failed!");
			return password;
		}
		
		char[] passwordChars = password.toCharArray(); // creates an array from password, so that individual characters can be changed.
		
		// loops through the password string
		for (int iterator = 0; iterator < password.length(); iterator++) {
			int shifting = (char)password.charAt(iterator) + getKey(); // sets integer value to the (int) value of current character plus the encryption key.
			if (shifting > 122) // checks if the integer value will overflow the encryption parameters (character 122).
				shifting -= 90; // brings the value of 'shifting' back into the bounds of 33-122, as if it loops from 122 back to 33.
			passwordChars[iterator] = (char)shifting; // puts the character value of shifting into the character array.
		}
		
		return String.valueOf(passwordChars);
	}
	
	/**
	 * @param inputPassword gets encrypted then compared to encyptedPassword.
	 * @return true if passwords match. Otherwise, false.
	 */
	public boolean isValidPassword(String inputPassword) {
		inputPassword = encrypt(inputPassword);
		return inputPassword.equals(getEncryptedPassword());
//		if (inputPassword.contentEquals(getEncyptedPassword()))
//			return true;
//		else
//			return false;
	}
	
	/**
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	
	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setPassword(int key, String password) {
		this.key = key;
		this.encryptedPassword = encrypt(password);
	}
	
	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "The encrypted password is " + getEncryptedPassword() + ". The key used to generate this password is " + getKey() + ".";
	}
	
}
