package application.model;

public enum Difficulty {
	EASY(1, 9), HARD(10, 99), ALL(1, 99);

	private int min;
	private int max;
		
	Difficulty (int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
}
