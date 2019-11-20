import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTest.
 */
public class UserTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		User luke = new User();
		luke.setName("Luke Williams");
		luke.setAge(32);
		luke.setEmail("lwill@hfowfwwer.com");
		luke.setSalary(0.0);
		luke.setHackerName("Spooky");
		System.out.println(luke.toString());
		
		String salary = "";
		boolean validSalary = false;
		while (!validSalary) {
			System.out.print("Enter new salary: ");
			salary = input.next();
			validSalary = luke.setSalary(salary);
		}
		
		String email = "";
		boolean validEmail = false;
		while(!validEmail) {
			System.out.print("Enter new email: ");
			email = input.next();
			validEmail = luke.setEmail(email);
		}
		
		System.out.println(luke.toString());
		input.close();
	}

}
