package application.model;

import java.util.ArrayList;
import java.util.Random;

public class ExamModel {
	
	private static ExamModel examModel = new ExamModel();
	
	private static ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	private int currentNumber = 0;
	
	private boolean practice = false;
		
	private ExamModel() {
	}
		
	public static ExamModel getExamModel() {
		if (examModel != null) {
			return examModel;
		}
		
		examModel = new ExamModel();
		return examModel;
	}
	
	public void createList(Difficulty difficulty) {
		Random rn = new Random();
		
		if (difficulty == Difficulty.EASY) {
			for (int i=0; i< 10; i++) {
				numbers.add(rn.nextInt(9) + 1);
			}
		}
		
		if (difficulty == Difficulty.HARD) {
			for (int i=0; i< 10; i++) {
				numbers.add(rn.nextInt(99) + 1);
			}
		}
	}
	
	public void createList(int practiceNumber) {
		numbers.add(practiceNumber);
	}
	
	public void resetExamModel(boolean practice) {
		ExamModel.examModel = new ExamModel();
	}
	
	public String getNext() {
		if (currentNumber < 9) {
			return "" + numbers.get(currentNumber++);	
		}
		return "" + numbers.get(currentNumber);
	}
}
