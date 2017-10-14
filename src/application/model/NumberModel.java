package application.model;

import java.util.Random;

public class NumberModel extends ExamModel{
	
	
	/**
     * Private constructor so no external classes can call it.
     */	
	private NumberModel() {
	}
	
	/**
     * Instantiates the ExamModel if it does not exist.
     * Otherwise it returns the existing one.
     */
	public static ExamModel getNumberModel() {
		if (examModel != null) {
			return examModel;
		}
		
		examModel = new NumberModel();
		return examModel;
	}
	
	/**
     * Creates a random list of ten numbers between the two values defined in the Difficulty Enum that is passed into it.
     */
	@Override
	public void createList(Difficulty difficulty) {
		super.difficulty = difficulty;
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
	public static void resetExamModel() {
		examModel = new NumberModel();
	}
	

}
