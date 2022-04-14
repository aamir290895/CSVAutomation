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
			String[] n = x.split("Expected Result:", 0);
			steps.add(n[0]);
//            ers.add(n.length);
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
			String[] n = x.split("Expected Result:", 0);
			
			if(n.length ==2) {
				ers.add(n[1]);
			}else {
				
				ers.add(" ");
			}
//            ers.add(n.length);
//            

		}

		er = ers.toArray(new String[ers.size()]);

		return er;

	}

	public static List<Integer> countSteps(int index) throws FileNotFoundException, IOException, CsvException {

		String[] steps = arrayOfString(index);

		String[] n = {};

		List<Integer> list = new ArrayList<>();

		for (String x : steps) {

			n = x.split("[\\d][.]");
			int count = n.length;
			list.add(count);

		}

		return list;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		String[] s = arrayOfRawSteps();

		int i = 0;
		for (String x : s) {
			i++;
			String[] n = x.split("Expected Result:", 2);

			System.out.println(n.length);
		}

	}

}
