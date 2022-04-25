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

		List<String> list = new LinkedList<String>();
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

	public static List<String[]> arrayOfRawSteps() throws FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfString(3);
		String[] n = {};
		List<String[]> list = new LinkedList<String[]>();

		for (String x : s) {

			if (x.isBlank() == true) {
				list.add(new String[] { " NA Expected Result: NA" });

			} else {
				n = x.split("[\\d][.]");
				list.add(n);
			}
		}

		return list;

	}

	public static String[] arrayOfSteps()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		List<String[]> s = arrayOfRawSteps();

		String[] step = {};

		List<String> steps = new LinkedList<>();
		for (int i = 0; i <= s.size() - 1; i++) {
			for (String x : s.get(i)) {
				
				
			  if (x.contains("Expected Result:") == true) {
				  String[] n = x.split("Expected Result:" , 2);
				  steps.add(n[0]);
				  
			  }else if(x.isBlank()==false && x.contains("Expected Result:") == false){
				  steps.add(x);
			  }

			}
		}
		step = steps.toArray(new String[steps.size()]);

		return step;

	}

	public static String[] expectedResults()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		List<String[]> s = arrayOfRawSteps();

		String[] step = {};

		List<String> steps = new LinkedList<>();
		for (int i = 0; i <= s.size() - 1; i++) {
			for (String x : s.get(i)) {
				
				
			  if (x.contains("Expected Result:") == true) {
				  String[] n = x.split("Expected Result:" , 2);
				  steps.add(n[1]);
				  
			  }else if(x.isBlank()==false && x.contains("Expected Result:") == false){
				  steps.add("NA");
			  }

			}
		}
		step = steps.toArray(new String[steps.size()]);

		return step;

	}

	public static String[] testType() throws FileNotFoundException, IOException, CsvException {

		return null;
	}

	public static List<Integer> countSteps() throws FileNotFoundException, IOException, CsvException {

		String[] pre = arrayOfString(3);

		List<String> ls = new ArrayList<String>();

		for (String x : pre) {

			if (x.isBlank() == true) {

				String y = x.replaceAll(x, "NA Expected Result: NA");
				ls.add(y);
			} else {
				ls.add(x);
			}
		}

		String[] steps = ls.toArray(new String[ls.size()]);

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
			y += x;

		}
		System.out.println(y);

	}

}
