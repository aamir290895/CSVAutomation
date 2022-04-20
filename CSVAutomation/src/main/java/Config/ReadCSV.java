package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

//	public static String joinString(int index) throws FileNotFoundException, IOException, CsvException {
//		String[] steps = ReadCSV.arrayOfString(index);
//
//		String output = "";
//
//		for (String x : steps) {
//			if (x == null) {
//				output = output.concat("1.Automated Expected Result: Automated");
//			} else {
//
//				output = output.concat(x);
//			}
//		}
//		return output;
//
//	}

	public static List<String[]> arrayOfRawSteps() throws FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfString(3);
		String[] n = {};
		List<String[]> list = new ArrayList<String[]>();
        
		for (String x : s) {
			
			if (x.isBlank()==false) {
				n = x.split("[\\d][.]");
				list.add(n);
			} else if (x.isBlank()==true) {
				list.add(new String[] { " NA Expected Result: NA" });
			}
		}

		return list;

	}

	public static String[] arrayOfSteps()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		List<String[]> s = arrayOfRawSteps();

		String[] step = {};

		List<String> steps = new ArrayList<>();
		for (int i = 0; i <= s.size() - 1; i++) {
			for (String x : s.get(i)) {
				String[] n = x.split("Expected Result:", 2);
				if (n.length == 2) {
					steps.add(n[0]);
				} else {
					steps.add(n[0]);
				}
//            

			}
		}
		step = steps.toArray(new String[steps.size()]);

		return step;

	}

	public static String[] expectedResults()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		List<String[]> s = arrayOfRawSteps();

		String[] step = {};

		List<String> steps = new ArrayList<>();
		for (int i = 0; i <= s.size() - 1; i++) {
			for (String x : s.get(i)) {
				String[] n = x.split("Expected Result:", 2);
				String y = "";
				if (n.length == 2) {
					steps.add(n[1]);
				} else {
					steps.add(y);
				}
//            

			}
		}
		step = steps.toArray(new String[steps.size()]);

		return step;

	}

	public static String[] testType() throws FileNotFoundException, IOException, CsvException {

		return null;
	}

	public static List<Integer> countSteps() throws FileNotFoundException, IOException, CsvException {

		String[] steps = arrayOfString(3);

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		int count = 0;

		for (int k = 0; k <= steps.length - 1; k++) {
			count = k;

			String[] n = steps[k].split("Expected Result:");

			for (int i = 0; i <= n.length - 2; i++) {

				if (n[i] != null) {

					list.add(count);
				}
			}

		}
		int noOfTimes = 0;
		for (int y = 0; y <= steps.length - 1; y++) {
			noOfTimes = Collections.frequency(list, y);
			list2.add(noOfTimes);
		}

		return list2;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		List<Integer> counts = countSteps();
		int y = 0;

		for (int x : counts) {
			System.out.println(x);

		}

	}

}
