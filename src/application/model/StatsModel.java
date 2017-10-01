package application.model;

import java.util.ArrayList;
import java.util.HashMap;

public class StatsModel 
{
	// Only one StatsModel is needed for each launch of the program.
	private static final StatsModel sm = new StatsModel();
	private HashMap<Difficulty, ArrayList<Stat>> statistics = new HashMap<Difficulty, ArrayList<Stat>>();
	
	/**
     * StatsModel constructor.
     * Puts a Difficulty along with an ArrayList of type Stat into a HashMap.
     * Each "Stat" ArrayList stores information on the number of correct and incorrect attempts at each number
     * for each given Difficulty.
     * The Hashmap is used for keeping a record of which ArrayList and which Difficulty belong together.
     */
	private StatsModel()
	{
		Difficulty difficulties[] = Difficulty.values();
		
		for (int i=0; i<difficulties.length; i++) 
		{
			ArrayList<Stat> al = new ArrayList<Stat>();
			for (int j=difficulties[i].getMin(); j<difficulties[i].getMax()+1; j++)
			{
				al.add(new Stat(j));
			}
			statistics.put(difficulties[i], al);
		}
	}
	
	/**
     * Returns the StatsModel object attached to the class.
     */
	public static StatsModel getInstance()
	{
		return sm;
	}
	
	/**
     * Returns the ArrayList of "Stat"s associated with the Difficulty input.
     */
	public ArrayList<Stat> getStats(Difficulty difficulty)
	{
		return statistics.get(difficulty);
	}
	/**
     * To be called whenever a question is attempted.
     * Method that updates the corresponding number in the ArrayList
     * depending on whether or not the answer is correct or not.
     */
	public void updateStats(Difficulty difficulty, int number, Boolean correct)
	{
		ArrayList<Stat> stats = statistics.get(difficulty);
		if (correct) stats.get(number-1).addToCorrect(1);
		if (!correct) stats.get(number-1).addToIncorrect(1);
	}
}
