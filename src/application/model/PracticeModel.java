package application.model;

public class PracticeModel extends ExamModel{
	
	
	
	/**
     * Private constructor so no external classes can call it.
     */	
	
	private PracticeModel() {
	}
	
	
	
	/**
     * Instantiates the ExamModel if it does not exist.
     * Otherwise it returns the existing one.
     */
	
	public static ExamModel getPracticeModel() {
		if (examModel != null) {
			return examModel;
		}
		
		examModel = new PracticeModel();
		return examModel;
	}
	
	
	
	/**
     * Creates a "list" of numbers to be used to test the user.
     * This method only puts one number into the list for practice purposes.
     */
	
	@Override
	public void createList(int practiceNumber) {
		numbers.clear();
		numbers.add(practiceNumber);
	}
	
	
	
	/**
     * Resets the ExamModel.
     * Doing this purges the list of 10 numbers, allowing a new list to be made.
     * Also tells the ExamModel if it is in practice mode or not.
     */
	
	public static void resetExamModel() {
		difficulty = null;
		numbers.clear();
		examModel = new PracticeModel();
	}
}
