package application.model;

public enum Window {
	MAIN("Main"), 
	LEVEL("Level"),
	EXAM("Exam"),
	STATISTICS("Statistics"),
	PRACTICE("Practise"),
	INSTRUCTION("Instruction"),
	END("End"),
	LEVELSELECT("LevelSelect");
	
	private final String name;
	
	private Window(final String name) {
		this.name=name;
	}

    @Override
    public String toString() {
        return name;
    }
}


