Tatai - Ravid Aharon, Zinzan Zhao. 2017

Prerequisites:
	In order to run Tatai, JavaFX must be installed on the machine. To install JavaFX, run "sudo apt install openjfx". The HTK folder must also be present in the same folder as "tatai.jar" 

How to run:
	Run the program by running the command "java -jar tatai.jar".

Instructions:
	Once launched, users will be be asked to log in.
	You can either make a new profile or choose from existing profiles from the ComboBox.
	After the login step, useres will be able to see the main menu screen. The main menu screen contains 5 buttons: Instructions, Statistics, Play, Practice and Switch User. 
	-Practice mode is a work in progress, and is yet to be functional. 
	-The instructions button navigates the user to the instructions window, which explains to the user how to use the app. 
	-The statistics button navigates the user to the statistics window, where the user can see the frequency of correct and incorrect pronounciations for each number in the selected level for the current session.
	-The play button navigates the user to the level select screen. 
		On this prototype, there are two game modes: Speaking and Equation, each with 2 levels: EASY (1-9) and HARD (10-99). 
		
		In speaking mode, once the user selects a difficulty, they will begin the game. 
		On the game Window, there are 2 main buttons: Record and Next. 
		Users have 2 attempts to correctly pronounce the number in Maori which is displayed at the top of the screen. 
		Once the record button is pressed, users have 3 seconds to say the number in Maori. 
		Their recording will then be played back to them. 
		If they are correct, they will be able to proceed to the next number. 
		If they are incorrect, they will get a second attempt. 
		If they are incorrect twice in a row, they will not be able to make another recording, and the number they should have said will be displayed. 
		This process is repeated 10 times. 
		Once the user finishes, they will be navigated to the end screen, where they can see which numbers they pronounced correctly and incorrectly, and be given a score out of 10. 
		The user can return to the main menu during any point.
		
		In Equation mode, the user must select both a difficulty and the operators that they wish to be tested on.
		Instead of a number, an equation will appear, for example instead of the number 7 appearing, you could get 49 - 42 (assuming the user selected division problems).
		Aside from these, everything is the same between the two modes, i.e. the layout is identical between the modes.
	-The Switch User button allows for profile switching.

STILL TO DO:
	 - Make reademe more readable
	 - Commenting
	 - Whitespace
	 - Test App again
	 - Make sure all error messages are where they should be
	 - MAYBE? remove prerequisite for hard mode?
	 - Replace all main menu buttons with "Back" buttons.
	 - MAYBE? Add a skip current question button?
	 
