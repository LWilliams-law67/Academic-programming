/**
 * This class handles bound type parameters that extend the API Number class.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3320	Lab 09
 * file name	MyMathClass.java
 */
import java.util.ArrayList;
import java.lang.Math;

/**
 * The Class MyMathClass.
 *
 * @param <T> the generic type
 */
public class MyMathClass<T extends Number> {

	/**
	 * Average.
	 *
	 * @param numbers the numbers
	 * @return the double
	 */
	public double average(ArrayList<T> numbers) {
		double average = 0.0;
		for (int i = 0; i < numbers.size(); i++) {
			average += numbers.get(i).doubleValue();
		}
		average = average / ((double)numbers.size());
		return average;
	}
	
	/**
	 * Standard deviation.
	 *
	 * @param numbers the numbers
	 * @return the double
	 */
	public double standardDeviation(ArrayList<T> numbers) {
		double average = average(numbers);
		double sum = 0.0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += (numbers.get(i).doubleValue()) - average;
		}
		return Math.sqrt(sum);
	}
}