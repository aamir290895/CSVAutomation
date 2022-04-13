package Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class ArrangeCSV {

	public static String[] csvArray(int a, int b, int c) throws FileNotFoundException, IOException, CsvException {

		String[] ids = ReadCSV.arrayOfString(0);

		String[] titles = ReadCSV.arrayOfString(1);
		
		List<String> list = new ArrayList<String>();
		list.add(" ");
		
		for(String x: titles) {
			
			list.add(x);
		}
		
		String[] titles2= list.toArray(new String[list.size()]);

		String[] steps = stepsArray();

		String[] expectedResult = expectedResults();

		String[] output = { ids[a], titles2[b], steps[c], expectedResult[c] };

		return output;

	}

	public static String[] expectedResults()
			throws FileNotFoundException, IOException, CsvException, ArrayIndexOutOfBoundsException {
		

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] steps = {};
		
		List<String> listSteps = new ArrayList<String>();

		for (int i = 0; i<=raw.length-1; i++) {

			if (i % 2 == 1) {
				listSteps.add(raw[i]);
			} else {
				
				System.out.println(i);
			}

		}

		steps = listSteps.toArray(new String[listSteps.size()]);

		return steps;
	}

	public static String[] stepsArray()
			throws FileNotFoundException, IOException, CsvException, ArrayIndexOutOfBoundsException {

		String[] raw = ReadCSV.arrayOfStepsAndExpectedResults();
		String[] steps = {};
		
		List<String> listSteps = new ArrayList<>();


		for (int j = 0; j<=raw.length-1; j++) {

			if (j % 2 == 0) {
				listSteps.add(raw[j]);
			} else {
				
				System.out.println(j);
			}
		}

		steps = listSteps.toArray(new String[listSteps.size()]);

		return steps;
	}

	public static List<Integer> repeatInt(int a) throws FileNotFoundException, IOException, CsvException {

//		List<Integer> n = ReadCSV.countSteps(3);

		List<Integer> s = new ArrayList<>();

		for (int k = 0; k <= a; k++) {

			s.add(k);

		}

		return s;

	}

	

}
