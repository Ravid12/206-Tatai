package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StatsModel 
{
	private ArrayList<String> al = new ArrayList<String>();
	
	public ArrayList<String> getStats()
	{
		try {
			File file = new File("test.txt");
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
	
	public ArrayList<String> StatsInfo()
	{
		return al;
	}
	
	public void updateStats()
	{
		try {
            FileWriter writer = new FileWriter("MyFile.txt", false);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
