/**
 * This class tests the MyMathClass class methods.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Lab 09
 * file name	MyMathClassTester.java
 */
import java.util.ArrayList;

public class MyMathClassTester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<Double> dubs = new ArrayList<Double>();
		ArrayList<Long> longs = new ArrayList<Long>();
		
		for (Integer i = 1; i < 5; i++) {
			ints.add(i);
		}
		
		for (double i = 1.0; i < 5.0; i++) {
			dubs.add(i * 2.3);
		}
		
		for (long i = 1L; i < 5; i++) {
			longs.add(i * 5999777444L);
		}
		
		MyMathClass<Integer> intMathClass = new MyMathClass<Integer>();
		MyMathClass<Double> dubMathClass = new MyMathClass<Double>();
		MyMathClass<Long> longMathClass = new MyMathClass<Long>();
		
		System.out.println("Integer Standard Deviation: " + intMathClass.standardDeviation(ints));
		System.out.println("Double Standard Deviation: " + dubMathClass.standardDeviation(dubs));
		System.out.println("Integer Standard Deviation: " + longMathClass.standardDeviation(longs));
		
//		MyMathClass<String> strings = new MyMathClass<String>();
//		Multiple markers at this line
//		- Bound mismatch: The type String is not a valid substitute for the bounded parameter 
//		 <T extends Number> of the type MyMathClass<T>
//		
//		Because the generic class is bound by a parameter type and extends Number class, Strings
//		are not a valid type.
	}	

}
