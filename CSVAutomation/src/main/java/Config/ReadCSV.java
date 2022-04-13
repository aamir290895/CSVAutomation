package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSV {

	public static Set<String> readIndex(int index) throws FileNotFoundException, IOException, CsvException {

		List<String[]> data = null;

		try (CSVReader reader = new CSVReader(new FileReader(FilePath.fileInput))) {
			data = reader.readAll();
		}

		Set<String> set = new HashSet<>();
		for (String[] arrays : data)
			set.add(arrays[index]);
		return set;

	}

	

	public static String[] arrayOfString(int index) throws FileNotFoundException, IOException, CsvException {

		Set<String> s = readIndex(index);

		String[] arrayOfString = new String[s.size()];

		int i = 0;
		for (String str : s)
			arrayOfString[i++] = str;
		return arrayOfString;

	}

	public static String joinString() throws FileNotFoundException, IOException, CsvException {
		String[] steps = ReadCSV.arrayOfString(3);

		String output = "";

		for (String x : steps) {

			output = output + "\n" + x;

		}
		return output;

	}

	public static String[] arrayOfRawSteps(int index) throws FileNotFoundException, IOException, CsvException {

		String s = joinString();
		String[] n = {};

		n = s.split("[\\d][.]");

		return n;

	}

	public static String[] arrayOfStepsAndExpectedResults() throws FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfRawSteps(3);
		String[] n = {};
		List<String> strings = new ArrayList<>();

		for (String x : s) {
			n = x.split("Expected Result:");

			for (String y : n) {

				strings.add(y);
			}

		}

		n = strings.toArray(new String[strings.size()]);

		return n;

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

		List<Integer> list = countSteps(3);
		
		System.out.println(list.toString());
	}

}
