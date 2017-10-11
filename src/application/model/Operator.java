package application.model;

public enum Operator {
	ADDITION("➕"),
	SUBTRACTION("➖"),
	MULTIPLICATION("X"),
	DIVISION("➗");
	
private final String name;
	
	private Operator(final String name) {
		this.name=name;
	}

    @Override
    public String toString() {
        return name;
    }
}
