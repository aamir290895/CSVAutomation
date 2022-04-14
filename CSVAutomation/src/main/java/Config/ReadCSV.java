package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSV {
	public static List<String> readIndex(int index) throws FileNotFoundException, IOException, CsvException {

		List<String[]> data = null;

		try (CSVReader reader = new CSVReader(new FileReader(FilePath.fileInput))) {
			data = reader.readAll();
		}

		List<String> list = new ArrayList<String>();
		for (String[] arrays : data)
			list.add(arrays[index]);
		return list;

	}

	public static String[] arrayOfString(int index) throws FileNotFoundException, IOException, CsvException {

		List<String> s = readIndex(index);

		String[] arrayOfString = new String[s.size()];

		int i = 0;
		for (String str : s)
			arrayOfString[i++] = str;
		return arrayOfString;

	}

	public static String joinString(int index) throws FileNotFoundException, IOException, CsvException {
		String[] steps = ReadCSV.arrayOfString(index);

		String output = "";

		for (String x : steps) {

			output = output.concat(x);

		}
		return output;

	}

	public static String[] arrayOfRawSteps() throws FileNotFoundException, IOException, CsvException {

		String s = joinString(3);
		String[] n = {};

		n = s.split("[\\d][.]");

		return n;

	}

	public static String[] arrayOfSteps()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfRawSteps();

		String[] step = {};

		List<String> steps = new ArrayList<>();

		for (String x : s) {
			String[] n = x.split("Expected Result:", 2);
			
			if(n.length ==2) {
				steps.add(n[0]);
			}else {
			}
//            

		}

		step = steps.toArray(new String[steps.size()]);

		return step;

	}

	public static String[] expectedResults()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfRawSteps();

		String[] er = {};

		List<String> ers = new ArrayList<>();

		for (String x : s) {
			String[] n = x.split("Expected Result:", 2);
			String y = "";

			if(n.length ==2) {
				y += n[1];
			}else {
				y += n[0];
			}
            ers.add(y);
//            

		}

		er = ers.toArray(new String[ers.size()]);

		return er;

	}
	
	
	
	public static String[] testType() throws FileNotFoundException, IOException, CsvException {
		
		
		return null;	
	}

	public static List<Integer> countSteps() throws FileNotFoundException, IOException, CsvException {

		String[] steps = arrayOfRawSteps();


		List<Integer> list = new ArrayList<>();
		int count = 0;

		for (String x : steps) {

			String[] n = x.split("Expected Result:",2);

			if(n.length ==2) {
				count++;
			}else {
				
			}

			list.add(count);

		}

		return list;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		List<Integer> counts = countSteps();

		int i = 0;
		for (int x : counts) {
			i++;

			System.out.println(x);
		}

	}

}
