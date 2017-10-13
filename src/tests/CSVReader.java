package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	/**
	 * Parse CSV File and returns list of string
	 * @param file
	 * @param split
	 * @return List<String[]>
	 */
	public static List<String[]> parse(String file, String split) {
		String line = "";
		List<String[]> result = new ArrayList<String[]>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while((line = reader.readLine()) != null) {
				result.add(line.split(split));
			}
		} catch(IOException error) {
			error.printStackTrace();
		}
		
		return result;
	}
}
