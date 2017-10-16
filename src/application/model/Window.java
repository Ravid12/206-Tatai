package application.model;
// An Enum that contains information on all "Windows" that get launched in the program.
public enum Window {
	MAIN("Main"), 
	LEVEL("Level"),
	EXAM("Exam"),
	STATISTICS("OverallStats"),
	PRACTICE("Practise"),
	INSTRUCTION("Instruction"),
	END("End"),
	LEVELSELECT("LevelSelect"),
	PRACTICESELECT("PracticeSelect"),
	EQUATIONSELECT("EquationSelect"),
	MODESELECT("ModeSelect"),
	USERSELECT("UserSelect"),
	DAILYSTATISTICS("DailyStats");
	
	private final String name;
	
	private Window(final String name) {
		this.name=name;
	}

    @Override
    public String toString() {
        return name;
    }
}


