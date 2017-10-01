package application.model;

import java.util.ArrayList;
import java.util.Random;

public class ExamModel {
	
	private static ExamModel examModel = new ExamModel();
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	private ArrayList<Correctness> isCorrectList = new ArrayList<Correctness>();

	private int currentNumber = 0;
	private boolean practice = false;
	private Difficulty difficulty;
	
	/**
     * Private constructor so no external classes can call it.
     */	
	private ExamModel() {
	}
	
	/**
     * Instantiates the ExamModel if it does not exist.
     * Otherwise it returns the existing one.
     */
	public static ExamModel getExamModel() {
		if (examModel != null) {
			return examModel;
		}
		
		examModel = new ExamModel();
		return examModel;
	}
	
	/**
     * Creates a random list of ten numbers between the two values defined in the Difficulty Enum that is passed into it.
     */
	public void createList(Difficulty difficulty) {
		this.difficulty = difficulty;
		Random rn = new Random();
		
		for (int i=0; i< 10; i++) {
			numbers.add(rn.nextInt(difficulty.getMax()-difficulty.getMin()+1) + difficulty.getMin());
		}
	}
	
	/**
     * Creates a "list" of numbers to be used to test the user.
     * This method only adds one number at a time for use with the practice mode.
     */
	public void createList(int practiceNumber) {
		numbers.add(practiceNumber);
	}
	
	/**
     * Resets the ExamModel.
     * Doing this purges the list of 10 numbers, allowing a new list to be made.
     * Also tells the ExamModel if it is in practice mode or not.
     */
	public static void resetExamModel(boolean practice) {
		ExamModel.examModel = new ExamModel();
		examModel.practice = practice;
	}
	
	/**
     * Returns the next number in the Randomly generated list.
     * If in pratice mode just returns the first number.
     */
	public String getNext() {
		if (!practice && currentNumber < 9) {
			return "" + numbers.get(currentNumber++);	
		}
		return "" + numbers.get(currentNumber);
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
}
