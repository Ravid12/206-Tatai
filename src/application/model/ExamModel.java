package application.model;

import java.util.ArrayList;

public class ExamModel {
	private ArrayList<Correctness> isCorrectList = new ArrayList<Correctness>();

	private int currentNumber = 0;
	protected int currentDisplay = 0;
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
	public String getNumber() {
		return "" + numbers.get(currentNumber);
	}
	
	public String getDisplay() {
		return "" + numbers.get(currentNumber);
	}
	
	public void nextNumber() {
		currentNumber ++;
		currentDisplay++;
	}
	
	
	/**
     * Returns all the Tested Numbers in an ArrayList.
     * This ArrayList is used primarily for Statistics display purposes.
     */
	public ArrayList<Integer> getTestedNumbers() {
		return numbers;
	}
	
	/**
     * Returns an ArrayList of "Correctness" values.
     * The Index position of each value corresponds to 
     * the index position of the tested number in the tested number ArrayList
     */
	public ArrayList<Correctness> getCorrectList() {
		return isCorrectList;
	}
	
	/**
     * Returns the Difficulty of the List of tested numbers.
     */
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	/**
     * Adds "Correctness" values to the Correctness ArrayList.
     */
	public void setCorrect(Boolean correct) {
		if(correct == true) {
			isCorrectList.add(Correctness.CORRECT);
		} else {
			isCorrectList.add(Correctness.INCORRECT);
		}
	}

	public void createList(Difficulty value) {
	}

}
