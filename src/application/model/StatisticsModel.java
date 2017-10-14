package application.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.utils.IOUtils;

public class StatisticsModel {
	private static StatisticsModel sm = new StatisticsModel();
	private String user = "user";

	private StatisticsModel() {
		
	}
	
	/**
	 * singleton method
	 * @return sm The singleton instance of statistics Model
	 */
	public static StatisticsModel getStatisticsModel() {
		if ( sm == null ) {
			sm = new StatisticsModel();
			return sm;
		}
		return sm;
	}
	
	public void startTempStat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		IOUtils.overwriteFile("stats/temp.txt", user + " " + dtf.format(localDate));
	}
	
	public void addTempStat(String question, String answer, boolean isCorrect) {
		IOUtils.appendFile("stats/temp.txt", question + "%" + answer + "%" + (isCorrect ? "Correct ✓" : "Incorrect ✕"));
	}
	
	public void saveStats() {
		//TODO: copy contents of temp.txt into user.txt
	}
	
	public void setUser(String user) {
		this.user = user;
	}

}
