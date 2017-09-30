package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.utils.IOUtils;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class StatsModel 
{
	private static final StatsModel sm = new StatsModel();
	private HashMap<Difficulty, ArrayList<Stat>> statistics = new HashMap<Difficulty, ArrayList<Stat>>();
	
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
	
	public static StatsModel getInstance()
	{
		return sm;
	}
	
	public ArrayList<Stat> getStats(Difficulty difficulty)
	{
		return statistics.get(difficulty);
	}
	
	public void updateStats(Difficulty difficulty, int number, Boolean correct)
	{
		ArrayList<Stat> stats = statistics.get(difficulty);
		if (correct) stats.get(number-1).addToCorrect(1);
		if (!correct) stats.get(number-1).addToIncorrect(1);
	}
	
//	private String sessionAveragePerGame(Difficulty difficulty)
//	{
//		if (difficulty.equals(Difficulty.EASY) && sessionEasyTries != 0)
//		{	
//			return (sessionEasyQuestionsCorrect / sessionEasyTries) + "";
//		}
//		
//		if (difficulty.equals(Difficulty.HARD) && sessionHardTries != 0)
//		{	
//			return (sessionHardQuestionsCorrect / sessionHardTries) + "";
//		}
//		else
//		{
//			return "0";
//		}
//	}
//	
//	public void updateCorrectTotal(Difficulty difficulty)
//	{
//		if (difficulty.equals(Difficulty.EASY))
//		{	
//			sessionEasyQuestionsCorrect++;
//		}
//		
//		if (difficulty.equals(Difficulty.HARD))
//		{	
//			sessionHardQuestionsCorrect++;
//		}
//		
//	}
//	
//	public void updateTriesTotal(Difficulty difficulty)
//	{
//		if (difficulty.equals(Difficulty.EASY))
//		{	
//			sessionEasyTries++;;
//		}
//		
//		if (difficulty.equals(Difficulty.HARD))
//		{	
//			sessionHardTries++;;
//		}
//	}
}
