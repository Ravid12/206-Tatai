package application.model;

import java.util.ArrayList;

public class ExamModel {
	protected static ExamModel examModel;
	
	protected Difficulty difficulty;
	protected ArrayList<Integer> numbers = new ArrayList<Integer>();

	
	
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
	
	public static void setDifficulty(Difficulty d) {
		this.difficulty=d;
	}
	
	public void createList() {
	}

}
