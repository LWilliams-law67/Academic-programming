// TODO: Auto-generated Javadoc
/**
 * This class stores user information.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab06
 * file name	User.java
 */

public class User {
	
	/** The name. */
	private String name;
	
	/** The hacker name. */
	private String hackerName;
	
	/** The age. */
	private int age;
	
	/** The salary. */
	private double salary;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {
		name = "John Doe";
		age = 0;
		salary = 0.0;
		hackerName = "Anonymous";
		email = "johndoe@email.com";
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the hacker name.
	 *
	 * @return the hacker name
	 */
	public String getHackerName() {
		return hackerName;
	}

	/**
	 * Sets the hacker name.
	 *
	 * @param hackerName the new hacker name
	 */
	public void setHackerName(String hackerName) {
		this.hackerName = hackerName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * Sets the salary.
	 *
	 * @param newSalary the new salary
	 * @return true, if successful
	 */
	public boolean setSalary(String newSalary) {
		try {
			double salary = Double.parseDouble(newSalary);
			this.salary = salary;
			return true;
		}
		catch (NumberFormatException nfe) {
			System.out.println("Not a valid number");
			System.out.println(nfe.getMessage());
			return false;
		}
		
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param newEmail the new email
	 * @return true, if successful
	 */
	public boolean setEmail(String newEmail) {
		try {
			if (newEmail.indexOf('@') != -1) {
				this.email = newEmail;
				return true;
			}
			else
				throw new Exception("MalformedEmailAddress");
		} 
		catch (Exception me) {
			System.out.println("Error: Malformed Email.");
			return false;
		}
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", hackerName=" + hackerName + ", age=" + age + ", salary=" + salary + ", email="
				+ email + "]";
	}
	
	
}
