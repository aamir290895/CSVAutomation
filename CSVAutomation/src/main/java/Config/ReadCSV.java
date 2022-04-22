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
			if (x.isBlank() == false) {
				n = x.split("[\\d][.]");
				list.add(n);

			} else {

				list.add(new String[] { " 1. NA Expected Result: NA" });
			}

		}

		return list;

	}

	public static String[] filterString() throws FileNotFoundException, IOException, CsvException {

		List<String[]> listSteps = arrayOfRawSteps();

		List<String> listPre = new LinkedList<String>();
		for (String[] x : listSteps) {

			for (String y : x) {

				if (y.split("Expected Result:", 2).length != 2 && y.isBlank() == false) {
					listPre.add(y + "Expected Result: NA");

				} else if (y.isBlank() == false) {
					listPre.add(y);
				}

			}

		}
		return listPre.toArray(new String[listPre.size()]);

	}

	public static String[] arrayOfSteps()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		String[] s = filterString();

		String[] step = {};

		List<String> steps = new LinkedList<>();
		String y = "";

		for (String x : s) {

			String[] n = x.split("Expected Result:", 2);
			if (n.length == 2) {
				y = n[0];
			} else {
			}
			steps.add(y);
		}
		step = steps.toArray(new String[steps.size()]);
		return step;

	}

	public static String[] expectedResults()
			throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {

		String[] s = filterString();

		String[] step = {};

		List<String> steps = new LinkedList<>();
		String y = "";

		for (String x : s) {

			String[] n = x.split("Expected Result:", 2);
			if (n.length == 2) {
				y = n[1];
			} else {
			}
			steps.add(y);
		}
		step = steps.toArray(new String[steps.size()]);
		return step;

	}

	public static List<Integer> countSteps() throws FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfString(3);
		List<String> listPre = new LinkedList<String>();
		for (String x : s) {

			if(x.isBlank() == true) {
				listPre.add("1. NA Expected Result: NA");
				
			}else {
				
				listPre.add(x);
			}
		}
		String[] steps = listPre.toArray(new String[listPre.size()]);

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		int count = 0;

		for (int k = 0; k <= steps.length - 1; k++) {
			count = k;

			String[] n = steps[k].split("[\\d][.]");

			for (int i = 0; i <= n.length - 2; i++) {

				list.add(count);

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
			y += x;

		}
		System.out.println(y);

	}

}
