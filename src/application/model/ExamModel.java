package application.model;

import java.util.ArrayList;

public class ExamModel {
	
	protected static ExamModel examModel;
	protected static Difficulty difficulty;
	protected ArrayList<Integer> numbers = new ArrayList<Integer>();

	
	
	/**
	 * Only children and itself can access this constructor
	 */
	protected ExamModel() {
	}
	
	
	
	/**
     * Instantiates the ExamModel if it does not exist.
     * Otherwise it returns the existing one.
     */
	
	public static ExamModel getExamModel() {
		return examModel;
	}	
	
	
	
	/**
     * Returns the current number in the Randomly generated list.
     */
	
	public String getNumber(int i) {
		return "" + numbers.get(i);
	}
	
	
	
	/**
     * Returns the current number in the Randomly generated list.
     * For display purposes
     */
	
	public String getDisplay(int i) {
		return "" + numbers.get(i);
	}
	
	
	
	/**
     * Returns all the Tested Numbers in an ArrayList.
     * This ArrayList is used primarily for Statistics display purposes.
     */
	
	public ArrayList<Integer> getTestedNumbers() {
		return numbers;
	}
	
	
	
	/**
     * Returns the Difficulty of the List of tested numbers.
     */
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	
	
	/**
     * Sets the Difficulty of the List of tested numbers.
     */
	
	public void setDifficulty(Difficulty d) {
		difficulty=d;
	}

	
	
	/**
	 * Template method to be overwritten by children
	 */
	
	public void createList() {		
	}
	
	
	
	/**
	 * Template method for practice mode
	 * @param practiceNumber
	 */
	
	public void createList(int practiceNumber) {
	}

}
