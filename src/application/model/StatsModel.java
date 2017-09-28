package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.utils.IOUtils;

public class StatsModel 
{
	private static final StatsModel sm = new StatsModel();
	private ArrayList<String> al = new ArrayList<String>();
	private HashMap<Difficulty, Stat> statistics = new HashMap<Difficulty, Stat>();
	
	private StatsModel()
	{
		Difficulty difficulties[] = Difficulty.values();
		for (int i=0; i<difficulties.length; i++) {
			statistics.put(difficulties[i], new Stat(difficulties[i].getMin(), difficulties[i].getMax()));
		}
	}
	
	public static StatsModel getInstance()
	{
		return sm;
	}
	
	public Stat getStats(Difficulty difficulty)
	{
		return sm.statistics.get(difficulty);
	}
	
	public void updateStats(String string)
	{
		new IOUtils().overwriteFile("test.txt", string);
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
