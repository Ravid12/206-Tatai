package application.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import application.utils.IOUtils;

public class StatisticsModel {
	private static StatisticsModel sm = new StatisticsModel();
	private String user = "testboi";

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

		IOUtils.overwriteFile("stats/temp.txt", "#"+dtf.format(localDate));
	}

	public void addTempStat(String question, String answer, boolean isCorrect) {
		IOUtils.appendFile("stats/temp.txt", question + "%" + answer + "%" + (isCorrect ? "Correct ✓" : "Incorrect ✕"));
	}

	public void saveStats() {
		ArrayList<String> fileContents = IOUtils.readFile("stats/temp.txt");
		String fileNameStats = "stats/" + user +".txt";
		String fileNameDates = "stats/" + user +"-dates.txt";

		File fileStats = new File(fileNameStats);
		File fileDates = new File(fileNameDates);
		try {
			if(!fileStats.createNewFile() && (!fileDates.createNewFile())) {
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		if (!IOUtils.readFile(fileNameDates).contains(fileContents.get(0).substring(1))) {
			IOUtils.appendFile(fileNameDates, fileContents.get(0).substring(1));
		}
		
		for(int i=0; i<fileContents.size(); i++) {
			IOUtils.appendFile(fileNameStats, fileContents.get(i));
		}
	}

	public ArrayList<Stat> loadDayStats() {
		ArrayList<String> lines = IOUtils.readFile("stats/" + user + ".txt");
		ArrayList<Stat> dayStats = new ArrayList<Stat>();

		Stat s = new Stat();
		s.setDate(lines.get(0).substring(1));
		for (int i=1; i<lines.size(); i++) {
			String[] data = lines.get(i).split("%");

			s.setEquation(data[0]);
			s.setNumber(data[1]);
			s.setResult(data[2]);

			if (!lines.get(i).equals("#"+s.getDate())) {
				dayStats.add(s);
				s = new Stat();
				s.setDate(lines.get(0).substring(1));
			}
		}
		return dayStats;		
	}

	public void setUser(String user) {
		this.user = user;
	}

}
