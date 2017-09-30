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
		this.difficulty = difficulty;
		Random rn = new Random();
		
		for (int i=0; i< 10; i++) {
			numbers.add(rn.nextInt(difficulty.getMax()-difficulty.getMin()+1) + difficulty.getMin());
		}
	}
	
	public void createList(int practiceNumber) {
		numbers.add(practiceNumber);
	}
	
	public static void resetExamModel(boolean practice) {
		ExamModel.examModel = new ExamModel();
		examModel.practice = practice;
	}
	
	public String getNext() {
		if (!practice && currentNumber < 9) {
			return "" + numbers.get(currentNumber++);	
		}
		return "" + numbers.get(currentNumber);
	}
	
	public ArrayList<Integer> getTestedNumbers() {
		return numbers;
	}
	
	public ArrayList<Correctness> getCorrectList() {
		return isCorrectList;
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	public void setCorrect(Boolean correct) {
		if(correct == true)
		{
			isCorrectList.add(Correctness.CORRECT);
		}
		
		else
		{
			isCorrectList.add(Correctness.INCORRECT);
		}
	}
}
