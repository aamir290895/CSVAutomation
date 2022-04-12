package Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opencsv.exceptions.CsvException;

public class ArrangeCSV {

	public static String[] csvArray(int a, int b, int c) throws FileNotFoundException, IOException, CsvException {

		String[] ids = ReadCSV.arrayOfString(0);

		String[] titles = ReadCSV.arrayOfString(1);

		String[] steps = steps();

		String[] expectedResult = expectedResults();

		String[] output = { ids[a], titles[b], steps[c], expectedResult[c] };

		return output;

	}



	public static String[] expectedResults()
			throws FileNotFoundException, IOException, CsvException, ArrayIndexOutOfBoundsException {

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] steps = {};
		List<String> listSteps = new ArrayList<String>();
		listSteps.add(raw[0]);

		for (int i = 0; i <= raw.length; i++) {

			listSteps.add(raw[i + 2]);
			
			System.out.println(raw[i+1]);



		}

		steps = listSteps.toArray(new String[listSteps.size()]);

		return steps;
	}

	public static String[] steps()
			throws FileNotFoundException, IOException, CsvException, ArrayIndexOutOfBoundsException {

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] er = {};
		List<String> strings = new ArrayList<String>();
		strings.add(raw[1]);

		for (int j = 1; j <= raw.length; j++) {
			strings.add(raw[j + 2]);
			
			System.out.println(raw[j+1]);

		}

		er = strings.toArray(new String[strings.size()]);

		return er;
	}

	public static List<Integer> repeatInt(int a) throws FileNotFoundException, IOException, CsvException {

//		List<Integer> n = ReadCSV.countSteps(3);

		List<Integer> s = new ArrayList<>();

		for (int k = 0; k <= a; k++) {

			s.add(k);

		}

		return s;

	}
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, CsvException {
		String[] s = ArrangeCSV.steps();
		for (int i = 0; i <= s.length; i++) {

			System.out.println(s[i] + "^^" );
		}
	}

}
