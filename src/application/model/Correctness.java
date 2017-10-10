package application.model;

// This Enum exists solely because boolean cannot be extended.
// A class for storing whether the question was answered correctly was required
// But additionally, the toString method needed to be overridden so a new class was created.
public enum Correctness {
	CORRECT("Correct\t✓"), INCORRECT("Incorrect\t✕");
	
	private String name;
	
	Correctness(String string) {
		this.name = string;
	}
	
	public String toString() {
		return name;
	}
}
