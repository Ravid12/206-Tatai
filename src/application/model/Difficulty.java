package application.model;

// This Enum exists to alter existing / add new difficulties to the app
// Any new Difficulty Enum added will be automatically integrated to all parts of the App.
public enum Difficulty {
	EASY(1, 9), HARD(1, 99);

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
