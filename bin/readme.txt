Tatai - Ravid Aharon, Zinzan Zhao. 2017

Prerequisites:
	In order to run Tatai, JavaFX must be installed on the machine. To install JavaFX, run "sudo apt install openjfx". The HTK folder must also be present in the same folder as "tatai.jar" 

How to run:
	Run the program by running the comman "java -jar tatai.jar".

Instructions:
	Once launched, users will be able to see the main menu screen. The main menu screen contains 4 buttons: Instructions, Statistics, Play and practice. 
	-Practice mode is a work in progress, and is yet to be functional. 
	-The instructions button navigates the user to the instructions window, which explains to the user how to use the app. 
	-The statistics button navigates the user to the statistics window, where the user can see the frequency of correct and incorrect pronounciations for each number in the selected level for the current session.
	-The play button navigates the user to the level select screen. On this prototype, there are two levels: EASY (1-9) and HARD (10-99). HARD difficulty is locked until the user gets at least 8/10 correct on EASY difficulty in the current session. Once the user selects a difficulty, they will begin the game. On the game Window, there are 2 main buttons: Record and Next. Users have 2 attempts to correctly pronounce the number in Maori which is displayed at the top of the screen. Once the record button is pressed, users have 3 seconds to say the number in Maori. Their recording will then be played back to them. If they are correct, they will be able to proceed to the next number. If they are incorrect, they will get a second attempt. If they are incorrect twice in a row, they will not be able to make another recording, and the number they should have said will be displayed. This process is repeated 10 times. Once the user finishes, they will be navigated to the end screen, where they can see which numbers they pronounced correctly and incorrectly, and be given a score out of 10. The user can return to the main menu during any point.
