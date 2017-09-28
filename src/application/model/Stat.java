package application.model;

import java.util.ArrayList;

public class Stat {
	private ArrayList<Integer> numbers;
	private ArrayList<Integer> correct;
	private ArrayList<Integer> incorrect;
	
	public Stat(int min, int max) {
		for(int i = min; i<max+1; i++)
		{
			numbers.add(i);
			correct.add(0);
			incorrect.add(0);
		}
	}
	
	public void update(int number, boolean right) {
		if (right) {
			correct.set(number, correct.get(number)+1);
		} else {
			incorrect.set(number, correct.get(number)+1);
		}
	}
	
	
	
}
