package application.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOUtils {

	public ArrayList<String> readFile(String FileName)
	{
		ArrayList<String> al = new ArrayList<String>();
		try {
			File file = new File(FileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				al.add(line);
				System.out.println(line.toString());
				
			}
			
			fileReader.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return al;
	}
	
	public void overwriteFile(String FileName, String string)
	{
		try {
            FileWriter writer = new FileWriter(FileName, false);
            writer.write(string);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}