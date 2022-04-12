package Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.exceptions.CsvException;

public class ArrangeCSV {

	public static String[] csvArray(int a, int b, int c)
			throws FileNotFoundException, IOException, CsvException {

		String[] id = ReadCSV.arrayOfString(0);

		String[] title = ReadCSV.arrayOfString(1);

		String[] steps = steps();

		String[] expectedResult = expectedResults();

		String[] output = { id[a], title[b], steps[c], expectedResult[c+1]};

		return output;

	}

//	public static String joinString(int k, int i) throws FileNotFoundException, IOException, CsvException {
//		String[] steps = ReadCSV.arrayOfString(3);
//
//		String output = "";
//
//		for (int j = 0; j <= i; j++) {
//
//			output = output + "\n" + steps[j + k];
//
//		}
//		return output;
//
//	}

	public static String[] steps() throws FileNotFoundException, IOException, CsvException {

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] steps= {};
		List<String> listSteps = new ArrayList<>();


		int j = 0;
		for (String x : raw) {

			int p = j++;
			if (p % 2 == 1) {
				listSteps.add(x);


			}

		}

		steps = listSteps.toArray(new String[listSteps.size()]);
		
		

		return steps;
	}

	public static String[] expectedResults() throws FileNotFoundException, IOException, CsvException {

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] er = {};
		List<String> strings = new ArrayList<>();

		int j = 0;
		for (String x : raw) {

			int p = j++;
			if (p % 2 == 0) {

				strings.add(x);

			}

		}

		er = strings.toArray(new String[strings.size()]);

		return er;
	}

}
