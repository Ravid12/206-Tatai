package application.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Utility classes do not need objects.
// They have few methods, all of which are pretty basic but extremely useful.
public class IOUtils {



	/**
	 * Method that reads the FileName that is passed in as a String input.
	 * returns Arraylist, where each element represents line of the file.
	 */

	public static ArrayList<String> readFile(String FileName)
	{
		ArrayList<String> al = new ArrayList<String>();
		try {
			File file = new File(FileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				al.add(line);				
			}
			fileReader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return al;
	}



	/**
	 * Method that writes a String to the FileName. 
	 * Both are passed in as a String input.
	 * @param FileName The FileName
	 * @param string The String to save
	 */

	public static void overwriteFile(String FileName, String string)
	{
		try {
			FileWriter writer = new FileWriter("./" + FileName, false);
			writer.write(string + "\r\n");   // write new line
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}



	/**
	 * Appends the String to the FileName
	 * @param FileName The FileName
	 * @param string The String to Append
	 */

	public static void appendFile(String FileName, String string)
	{
		try {
			FileWriter writer = new FileWriter("./" + FileName, true);
			writer.write(string);
			writer.write("\r\n");   // write new line
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/**
	 * Deletes all the files associated with the user
	 * @param user The user to remove all files for.
	 */

	public static void deleteUser(String username)
	{
		try {
			new File("./stats/" + username +".txt").delete();
			new File("./stats/" + username +"-dates.txt").delete();
			
			File inputFile = new File("./stats/users/user.txt");
			File tempFile = new File("./stats/users/myTempFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;

			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(username)) continue;
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			tempFile.renameTo(inputFile);
			new File("./stats/users/myTempFile.txt").delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
