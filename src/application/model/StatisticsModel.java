package application.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import application.utils.IOUtils;

public class StatisticsModel {
	
	private static StatisticsModel sm = new StatisticsModel();
	private String user;
	private int roundScore = 0;
	
	
	
	/**
	 * private constructor for StatisticsModel so no other class can instantiate it
	 */
	
	private StatisticsModel() {

	}

	
	
	/**
	 * Singleton method
	 * @return sm The singleton instance of statistics Model
	 */
	
	public static StatisticsModel getStatisticsModel() {
		if ( sm == null ) {
			sm = new StatisticsModel();
			return sm;
		}
		return sm;
	}

	
	
	/**
	 * Creates a temporary statistics file
	 */
	
	public void startTempStat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		IOUtils.overwriteFile("stats/temp.txt", "#"+dtf.format(localDate));
		roundScore = 0;
	}

	
	
	/**
	 * Adds more statistics to the temporary stats file
	 * @param question
	 * @param answer
	 * @param isCorrect
	 */
	
	public void addTempStat(String question, String answer, boolean isCorrect) {
		IOUtils.appendFile("stats/temp.txt", question + "%" + answer + "%" + (isCorrect ? "Correct ✓" : "Incorrect ✕"));
		if (isCorrect) {
			roundScore++;
		}
	}

	
	
	/**
	 * Saves statistics to appropriate save files
	 */
	
	public void saveStats() {
		ArrayList<String> tempStats = IOUtils.readFile("stats/temp.txt");
		String fileNameStats = "stats/" + user +".txt";
		String fileNameDates = "stats/" + user +"-dates.txt";

		if (!IOUtils.readFile(fileNameDates).contains(tempStats.get(0).substring(1))) {
			IOUtils.appendFile(fileNameDates, tempStats.get(0).substring(1));
		}

		for(int i=0; i<tempStats.size(); i++) {
			IOUtils.appendFile(fileNameStats, tempStats.get(i));
		}
	}

	
	
	/**
	 * Loads the Statistics for a user for a given date
	 * @param date: The date that Stats are sorted by
	 * @return
	 */
	public ArrayList<Stat> loadDayStats(String date) {
		ArrayList<String> lines = IOUtils.readFile("stats/" + user + ".txt");
		ArrayList<Stat> dayStats = new ArrayList<Stat>();
		String currentDate = "";

		if (!(lines.size()==0)) {
			for (int i=0; i<lines.size(); i++) {
				if (lines.get(i).startsWith("#")) {
					currentDate = lines.get(i).substring(1);
				}
				
				else if (currentDate.equals(date)) {
					Stat s = new Stat();
					s.setDate(date);
					String[] data = lines.get(i).split("%");
					
					s.setEquation(data[0]);
					s.setNumber(data[1]);
					s.setResult(data[2]);
					
					dayStats.add(s);
				}
			}
		}
		return dayStats;		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Stat> loadGlobalStats() {
		ArrayList<Stat> globalStats = new ArrayList<Stat>();

		return globalStats;
	}

	
	
	/**
	 * Creates new save files for the current Tatai sser
	 * @param user: Current User
	 */
	public void setUser(String user) {
		this.user = user;

		String fileNameStats = "stats/" + user +".txt";
		String fileNameDates = "stats/" + user +"-dates.txt";

		File fileStats = new File(fileNameStats);
		File fileDates = new File(fileNameDates);
		try {
			fileStats.createNewFile();
			fileDates.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Gets the current Tatai user
	 * @return The current User logged in to the Tataa
	 */
	public String getCurrentUser() {
		return user;
	}
	
	
	
	/**
	 * Gets dates from the dates text file
	 * @return An ArrayList of Dates in String format
	 */
	public ArrayList<String> getDates() {	
		return IOUtils.readFile("stats/" + user + "-dates.txt");
	}
	
	
	
	/**
	 * Gets RoundScore
	 * @return
	 */
	public int getRoundScore() {
		return roundScore;
	}
	
	
	
	/**
	 * Resets roundScore field
	 */
	public void resetRoundScore() {
		roundScore = 0;
	}
}
