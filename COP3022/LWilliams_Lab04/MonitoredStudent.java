/**
 * This class extends the Students.java class from Lab02, and provides a way to
 * monitor a Student on academic probation.
 * 
 * @author spooky
 * @version 1.0
 * 
 * COP3022	Lab04
 * filename	MonitoredStudent.java
 */

public class MonitoredStudent extends Student {
	/**
	 * An integer to hold a Student's minimum passing average.
	 */
	private int minPassingAvg;

	/**
	 * Default constructor that also calls Student default constructor.
	 */
	public MonitoredStudent() {
		super();
		minPassingAvg = 0;
	}

	/**
	 * @param name
	 * @param minPassingAvg
	 */
	public MonitoredStudent(String name, int minPassingAvg) {
		super(name);
		this.minPassingAvg = minPassingAvg;
	}

	/**
	 * @return the minPassingAvg
	 */
	public int getMinPassingAvg() {
		return minPassingAvg;
	}

	/**
	 * @param minPassingAvg the minPassingAvg to set
	 */
	public void setMinPassingAvg(int minPassingAvg) {
		this.minPassingAvg = minPassingAvg;
	}

	
	/**
	 * @return true if Student's average is equal to or above minPassingAvg.
	 */
	public boolean isOffProbation() {
		if (super.getAverageScore() < minPassingAvg)
			return false;
		else
			return true;
	}
	
	
}
