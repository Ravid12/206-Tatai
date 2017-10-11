package application.model;

import java.util.ArrayList;
import java.util.Random;

public class EquationModel extends ExamModel{

	private static ArrayList<Operator> operators;

	private static ArrayList<String> equations = new ArrayList<String>();


	/**
	 * Private constructor so no external classes can call it.
	 */	
	private EquationModel() {
	}

	/**
	 * Instantiates the ExamModel if it does not exist.
	 * Otherwise it returns the existing one.
	 */
	public static ExamModel getEquationModel() {
		if (examModel != null) {
			return examModel;
		}

		examModel = new EquationModel();
		return examModel;
	}

	/**
	 * Creates a random list of ten numbers between the two values defined in the Difficulty Enum that is passed into it.
	 */
	public void createList(Difficulty difficulty) {
		super.difficulty = difficulty;
		Random rn = new Random();

		for (int i=0; i< 10; i++) {			
			Equation e = new Equation(operators.get(rn.nextInt(operators.size())), difficulty.getMax(), difficulty.getMin());
			numbers.add(e.getResult());
			equations.add(e.toString());
		}
	}

	/**
	 * Creates a "list" of numbers to be used to test the user.
	 * This method only adds one number at a time for use with the practice mode.
	 */
	public void createList(ArrayList<Equation> practiceList) {
		for (Equation e: practiceList) {
			equations.add(e.toString());
			numbers.add(e.getResult());
		}
	}

	@Override
	public String getDisplay() {
		return "" + equations.get(currentDisplay);
	}

	/**
	 * Resets the ExamModel.
	 * Doing this purges the list of 10 numbers, allowing a new list to be made.
	 * Also tells the ExamModel if it is in practice mode or not.
	 */
	public static void resetExamModel(ArrayList<Operator> operators) {
		EquationModel.operators = operators;
		examModel = new EquationModel();
	}


}
