package application.model;

public enum Correctness {
	CORRECT("Correct"), INCORRECT("Incorrect");
	
	private String name;
	
	Correctness(String string) 
	{
		this.name = string;
	}
	
	public String toString()
	{
		return name;
	}
}
