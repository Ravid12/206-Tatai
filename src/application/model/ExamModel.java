package application.model;

import java.util.Random;

public class ExamModel {
	
	private static ExamModel examModel = new ExamModel();
	
	private static int[] numbers = new int[10];
	
	private int currentNumber = 0;
		
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
				numbers[i]=rn.nextInt(10) + 1;
			}
		}
		
		if (difficulty == Difficulty.HARD) {
			for (int i=0; i< 10; i++) {
				numbers[i]=rn.nextInt(100) + 1;
			}
		}
	}
	
	public void resetExamModel() {
		ExamModel.examModel = new ExamModel();
	}
	
	public String getNext() {
		return "" + numbers[currentNumber++];
	}
	
	public static void judge () {
		numbers[0]=999;
	}
}
