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
	
	public void createList() {
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
	public String getDisplay(int i) {
		return "" + equations.get(i);
	}

	
	
	/**
	 * Resets the ExamModel.
	 * Doing this purges the list of 10 numbers, allowing a new list to be made.
	 */
	
	public static void resetExamModel() {
		numbers.clear();
		equations.clear();
		examModel = new EquationModel();
	}
	
	
	
	/**
	 * Sets the operators that can be used in an Equation List (Quiz)
	 */
	
	public static void setOperators(ArrayList<Operator> o) {
		operators = o;
	}

}
